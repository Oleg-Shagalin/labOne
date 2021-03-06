package oop.model;

public class Account {
    private long number;
    private Person person;
    private IndividualsTariff tariff;

    public Account(long number, Person person) {
        this.number = number;
        this.person = person;
        tariff = new IndividualsTariff(1);
    }

    public Account(long number, Person person, IndividualsTariff tariff) {
        this.number = number;
        this.person = person;
        this.tariff = tariff;
    }

    public long getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public IndividualsTariff getTariff() {
        return tariff;
    }

    public void setTariff(IndividualsTariff tariff) {
        this.tariff = tariff;
    }

}
