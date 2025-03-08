package spring.boot.itau.backend.challenge.dtos;

import java.util.DoubleSummaryStatistics;

import lombok.Getter;

@Getter
public class StatisticsResponseDTO {
    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public StatisticsResponseDTO(DoubleSummaryStatistics statistics){
        this.count = statistics.getCount();
        this.sum = statistics.getSum();
        this.avg = statistics.getAverage();
        this.min = statistics.getMin();
        this.max = statistics.getMax();
        if(Double.isInfinite(this.max)){
            this.max = 0;
        }
        if(Double.isInfinite(this.min)){
            this.min = 0;
        }
    }
}
