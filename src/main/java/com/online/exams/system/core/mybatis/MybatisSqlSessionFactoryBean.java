package com.online.exams.system.core.mybatis;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.NestedIOException;
import org.springframework.core.io.Resource;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * 扩展默认的MyBatis工厂类，自动扫描指定的所有包前缀下实现IEnum接口的枚举类，并对其注册类型处理器EnumValueTypeHandler
 *
 * @author xianwen.tan
 */
public class MybatisSqlSessionFactoryBean extends SqlSessionFactoryBean {

    protected static final ConcurrentHashMap<Class<?>, EnumValueTypeHandler<?>> TYPE_HANDLER_CACHE =
            new ConcurrentHashMap<Class<?>, EnumValueTypeHandler<?>>();
    private static final Log logger = LogFactory.getLog(MybatisSqlSessionFactoryBean.class);
    /**
     * 指定需扫描的枚举类所在包的前缀，可以指定多个包，会自动扫描所有子包。分隔符与spring的包路径分隔符兼容。
     */
    protected String enumBasePackages;
    protected SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    protected Resource[] mapperLocations;

    @Override
    public void setSqlSessionFactoryBuilder(SqlSessionFactoryBuilder sqlSessionFactoryBuilder) {
        super.setSqlSessionFactoryBuilder(sqlSessionFactoryBuilder); // 由于父类sqlSessionFactoryBuilder字段为私有，覆盖次注入方法后，必须给父类手动注入一次
        this.sqlSessionFactoryBuilder = sqlSessionFactoryBuilder;
    }

    /**
     * 覆盖父类，拦截直接注入的mapperLocations，在子类中解析，禁止在父类中解析。
     */
    @Override
    public void setMapperLocations(Resource[] mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public void setEnumBasePackages(String enumBasePackages) {
        this.enumBasePackages = enumBasePackages;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
        SqlSessionFactory oldSqlSessionFactory = super.buildSqlSessionFactory();
        Configuration configuration = oldSqlSessionFactory.getConfiguration();
        // 注意：type handler的注册必须在mapperLocations解析之前
        TypeHandlerRegistry registry = configuration.getTypeHandlerRegistry();
        String[] enumPackages = parseEnumBasePackage();
        if (null != enumPackages) {
            try {
                Set<Class<?>> enumClasses = doScanEnumClass(enumPackages);
                if (null != enumClasses) {
                    for (Class<?> cls : enumClasses) {
                        logger.debug("check-EnumValueTypeHandler is registered for type " + cls.getName());
                        registry.register(cls, getEnumValueTypeHandlerInstance(cls));// 显示注册枚举处理器
                        if (logger.isDebugEnabled()) {
                            logger.debug("EnumValueTypeHandler is registered for type " + cls.getName());
                        }
                    }
                }
            }catch (Exception e){

            }

        }

        if (!isEmpty(this.mapperLocations)) {
            for (Resource mapperLocation : this.mapperLocations) {
                if (mapperLocation == null) {
                    continue;
                }

                try {
                    XMLMapperBuilder xmlMapperBuilder =
                            new XMLMapperBuilder(mapperLocation.getInputStream(), configuration, mapperLocation.toString(), configuration.getSqlFragments());
                    xmlMapperBuilder.parse();
                } catch (Exception e) {
                    throw new NestedIOException("Failed to parse mapping resource: '" + mapperLocation + "'", e);
                } finally {
                    ErrorContext.instance().reset();
                }

                if (logger.isDebugEnabled()) {
                    logger.debug("Parsed mapper file: '" + mapperLocation + "'");
                }
            }
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("Property 'mapperLocations' was not specified or no matching resources found");
            }
        }
        return this.sqlSessionFactoryBuilder.build(configuration);
    }

    /**
     * 获取枚举对应的handler实例，获取后该枚举对应的handle实例被缓存起来
     *
     * @param enumClass
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected EnumValueTypeHandler getEnumValueTypeHandlerInstance(Class<?> enumClass) {
        if (TYPE_HANDLER_CACHE.containsKey(enumClass)) {
            return TYPE_HANDLER_CACHE.get(enumClass);
        }
        logger.warn("check-getEnumValueTypeHandlerInstance:" + enumClass);
        EnumValueTypeHandler<?> handler = new EnumValueTypeHandler(enumClass);
        TYPE_HANDLER_CACHE.putIfAbsent(enumClass, handler);
        return handler;
    }

    /**
     * 搜索实现IEnum接口的枚举类
     *
     * @param enumBasePackages
     * @return
     */
    protected Set<Class<?>> doScanEnumClass(String... enumBasePackages) throws ClassNotFoundException {
//        logger.warn("check-doScanEnumClass:" + Thread.currentThread().getContextClassLoader().getClass().getName());
//        Set<Class<? extends IEnumValue>> filterdClasses = new HashSet<Class<? extends IEnumValue>>();
//        ResolverUtil<IEnumValue> resolverUtil = new ResolverUtil<IEnumValue>();
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        Thread.currentThread().setContextClassLoader(MybatisSqlSessionFactoryBean.class.getClassLoader());
//        resolverUtil.findImplementations(IEnumValue.class, enumBasePackages);
//        Thread.currentThread().setContextClassLoader(classLoader);
//
//        Set<Class<? extends IEnumValue>> handlerSet = resolverUtil.getClasses();
//        for (Class<? extends IEnumValue> type : handlerSet) {
//            logger.warn("check-doScanEnumClass:"+type);
//            if (type.isEnum()) {
//                logger.warn("check-true-doScanEnumClass:"+type);
//                filterdClasses.add(type);
//            }
//        }
//
//        return filterdClasses;
        Set<Class<?>> enumClasses = new HashSet<>();
        if(ArrayUtils.isEmpty(enumBasePackages)){
            return enumClasses;
        }
        ClassPathScanningCandidateComponentProvider componentProvider = new ClassPathScanningCandidateComponentProvider(false);
        componentProvider.addIncludeFilter(new AssignableTypeFilter(IEnumValue.class));
        for(String pkg : enumBasePackages){
            if(org.apache.commons.lang3.StringUtils.isEmpty(pkg)){
                continue;
            }
            for(BeanDefinition candidate : componentProvider.findCandidateComponents(pkg)){
                Class<?> cls = ClassUtils.forName(candidate.getBeanClassName(),MybatisSqlSessionFactoryBean.class.getClassLoader());
                if(cls.isEnum()){
                    enumClasses.add(cls);
                }
            }
        }
        return enumClasses;
    }

    protected String[] parseEnumBasePackage() {
        logger.warn("check-parseEnumBasePackage:" + this.enumBasePackages);
        return StringUtils.tokenizeToStringArray(this.enumBasePackages, ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);
    }

}
