package models;

import lombok.*;

@Builder
@ToString
@EqualsAndHashCode
public class MilestoneBuilder {
    @EqualsAndHashCode.Exclude //Исключаю поле из проверки в тесте на асерт
    private int id;
    @NonNull //пораметр становиться обязательным (можно указать что бы создавался конструктор только с обязательными полями )
    private String name;
    private String references;
    private String descriptions;
    @ToString.Exclude
    private boolean completed;


}
