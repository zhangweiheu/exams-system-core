package com.online.exams.system.core.util;

import com.online.exams.system.core.bean.QuestionMap;
import com.online.exams.system.core.mybatis.enums.QuestionTypeEnum;
import com.online.exams.system.core.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zhang on 2016/3/12.
 */
public class PaperUtil {
    public static double calculateAverageDifficultyOfQuestion(List<Question> questionList) {
        double difficultyDegree = 0.0;

        Double s = 0.0;
        Double sn = 0.0;
        Double m = 0.0;
        Double mn = 0.0;
        Double p = 0.0;
        Double pn = 0.0;

        if (null != questionList && 0 == questionList.size()) {
            for (Question question : questionList) {
                switch (question.getQuestionType()) {
                    case SINGLE_SELECTION:
                        s += question.getDifficulty();
                        sn++;
                        break;
                    case MULTI_SELECTION:
                        m += question.getDifficulty();
                        mn++;
                        break;
                    case PROGRAMMING_QUESTION:
                        p += question.getDifficulty();
                        pn++;
                        break;
                    default:
                        break;
                }
            }
            difficultyDegree = s / (10 * sn) * 40 + m / (10 * mn) * 20 + p / (10 * pn) * 40;
        }

        return difficultyDegree / 100.0;
    }

    public static double calculateAverageDifficultyOfQuestionMap(List<QuestionMap> questionList) {
        double difficultyDegree = 0.0;

        Double s = 0.0;
        Double m = 0.0;
        Double p = 0.0;

        if (null != questionList && questionList.size() > 0) {
            for (QuestionMap questionMap : questionList) {
                switch (questionMap.getQuestionType()) {
                    case SINGLE_SELECTION:
                        s += questionMap.getDifficulty().doubleValue()/10.0;
                        break;
                    case MULTI_SELECTION:
                        m += questionMap.getDifficulty().doubleValue()/10.0;
                        break;
                    case PROGRAMMING_QUESTION:
                        p += questionMap.getDifficulty().doubleValue()/10.0;
                        break;
                    default:
                        break;
                }
            }
        }
        difficultyDegree = s+m+p;
        return difficultyDegree;
    }

    public static List<QuestionMap> generateRandomQuestionListByCount(List<QuestionMap> questionList, int count) {
        if (null == questionList || questionList.size() < count) {
            return questionList;
        }
        List<QuestionMap> newQuestionList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int r = (int) random.nextDouble() * questionList.size();
            newQuestionList.add(questionList.get(r));
            questionList.remove(r);
        }
        return newQuestionList;
    }

    public static List<Integer> getRandomNumberByTotalAndCount(int total, int count) {
        int currentRemain = total;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            int r = currentRemain / (count - i + 1);
            list.add(r);
            currentRemain = currentRemain - r;
        }
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int r = (int) (random.nextDouble() * list.size());
            result.add(list.get(r));
            list.remove(r);
        }
        return result;
    }


    public static double calautePaperScore(List<QuestionMap> questionList) {
        double difficultyDegree = 0.0;

        Double s = 0.0;
        Double m = 0.0;
        Double p = 0.0;

        if (null != questionList && 0 != questionList.size()) {
            for (QuestionMap questionMap : questionList) {
                if (QuestionTypeEnum.SINGLE_SELECTION == questionMap.getQuestionType() && questionMap.getRight()) {
                    s += questionMap.getDifficulty();
                }
                if (QuestionTypeEnum.MULTI_SELECTION == questionMap.getQuestionType() && questionMap.getRight()) {
                    m += questionMap.getDifficulty();
                }
                if (QuestionTypeEnum.PROGRAMMING_QUESTION == questionMap.getQuestionType() && questionMap.getRight()) {
                    p += questionMap.getDifficulty();
                }

            }
            difficultyDegree = s / (10.0) * (2.0) + m / (10.0) * (2.0) + p / (10.0) * (40.0);
        }
        return difficultyDegree;
    }



    public static int calautePaperTotalSuccess(List<QuestionMap> questionList) {
        int total = 0;
        if (null != questionList && 0 != questionList.size()) {
            for (QuestionMap questionMap : questionList) {
                if (questionMap.getRight()) {
                    total++;
                }
            }
        }
        return total;
    }
}
