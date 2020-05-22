package oop.model;

public class Test {

    public static void lab1tests() {

        IndividualsTariff tariff = new IndividualsTariff();
        IndividualsTariff tariff1 = new IndividualsTariff(3);

        Service[] services = new Service[3];
        services[0] = new Service();
        IndividualsTariff tariff2 = new IndividualsTariff(services);

        tariff.add(1, new Service());
        for (Service s : services) {
            System.out.println(s);
        }

        for (int i = 0; i < 8; i ++) {
            tariff.add(new Service(String.valueOf(i), i));
        }
        for (Service s : tariff.getServices()) {
            System.out.println(s);
        }

        Service service = tariff.get(1);
        System.out.println(service.getName());

        service = tariff.get("3");
        System.out.println(service.getName());

        System.out.println("hasService " + "4: " + tariff.hasService("4"));

        service = tariff.set(0, new Service());
        System.out.println(service.getName());

        service = tariff.remove(3);
        System.out.println(service.getName());

        service = tariff.remove(0);
        System.out.println(service.getName());

        service = tariff.remove("5");
        System.out.println(service.getName());

        System.out.println("size: " + tariff.size());

        services = tariff.sortedServicesByCost();
        for (Service s : services) {
            System.out.println(s.getCost());
        }

        System.out.println(tariff.cost());


        Person person = new Person("Ivan", "Ivanov");
        System.out.println("name: " + person.getFName());
        System.out.println("surname: " + person.getSName());


        Account account = new Account(3, person);
        Account account1 = new Account(4, new Person("Petr", "Petrov"), tariff);

        System.out.println(account.getNumber());
        System.out.println(account.getPerson().getSName());
        System.out.println(account.getTariff().cost());
        account1.setPerson(person);


        AccountsManager manager = new AccountsManager(3);
        Account[] accounts = new Account[2];
        accounts[0] = account;
        accounts[1] = account1;
        AccountsManager manager1 = new AccountsManager(accounts);
        System.out.println(manager.add(account));
        System.out.println(manager.add(2, account1));
        account = manager.get(0);
        account = manager.set(2, account);
        account = manager.remove(1);
        System.out.println(manager.size());

        accounts = manager.getAccounts();
        for (Account a : accounts) {
            System.out.println(a);
        }

        tariff = manager.getTariff(3);
        System.out.println(tariff.cost());

        tariff = manager.setTariff(3, tariff1);
        System.out.println(tariff.cost());
    }

    @org.junit.Test
    public void startTests() {
        lab1tests();
    }

}
