package lab.book.control;

import java.text.DecimalFormat;
import java.util.*;
import lab.book.entity.*;

public class StatisticAnalyzer {
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###");

        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        System.out.println("===== 출판물 통계 분석 =====");
        System.out.println("1. 타입별 평균 가격:");
        for (String type : avgPrices.keySet()) {
            System.out.println("   - " + type + ": " + df.format(avgPrices.get(type)) + "원");
        }

        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        System.out.println("\n2. 출판물 유형 분포:");
        for (String type : distribution.keySet()) {
            System.out.printf("   - %s: %.2f%%\n", type, distribution.get(type));
        }

        double ratio = calculatePublicationRatioByYear(publications, "2007");
        System.out.printf("\n3. 2007년에 출판된 출판물 비율: %.2f%%\n", ratio);
        System.out.println("=============================");
    }

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> total = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            total.put(type, total.getOrDefault(type, 0) + pub.getPrice());
            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avg = new HashMap<>();
        for (String type : total.keySet()) {
            avg.put(type, total.get(type) / (double) count.get(type));
        }
        return avg;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> count = new HashMap<>();
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> result = new HashMap<>();
        int total = publications.length;
        for (String type : count.keySet()) {
            result.put(type, (count.get(type) * 100.0) / total);
        }
        return result;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return (count * 100.0) / publications.length;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        else if (pub instanceof Magazine) return "잡지";
        else if (pub instanceof ReferenceBook) return "참고서";
        else return "기타";
    }
}
