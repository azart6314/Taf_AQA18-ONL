package models;

import lombok.*;

//@Setter
//@Getter
//@AllArgsConstructor //создает конструктор
//@NoArgsConstructor //создает конструктор
//@ToString // выводит все параметры объекта
@Data //заменяет все анатаций выше
@RequiredArgsConstructor //Конструтор который выводит только обязательные поля

public class Milestone {
    @EqualsAndHashCode.Exclude //Исключаю поле из проверки в тесте на асерт
    private int id;
    @NonNull //пораметр становиться обязательным (можно указать что бы создавался конструктор только с обязательными полями )
    private String name;
    private String references;
    @ToString.Exclude //Исключаю поле из теста ( поле просто не выводиться)
    private String descriptions;
    private boolean completed;


}
