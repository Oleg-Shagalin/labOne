package oop.model;

import org.intellij.lang.annotations.MagicConstant;

public class IndividualsTariff {
    @MagicConstant(intValues = {SERVICE_CHARGE})
    private Service[] services;
    private int size = 0;
    public static final int SERVICE_CHARGE = 50;

    public IndividualsTariff() {
        services = new Service[8];
    }

    public IndividualsTariff(int size) {
        services = new Service[size];
    }

    public IndividualsTariff(Service[] services) {
        this.services = services;

        for (Service service : services) {
            if (service != null)
                size++;
        }

    }

    public boolean add(Service service) {
        for (int i = 0; i < services.length; i++) {
            if (services[i] == null) {
                services[i] = service;
                size++;
                return true;
            }
        }

        increaseArray();
        return add(service);
    }

    public void increaseArray() {
        Service[] temp = new Service[services.length * 2];
        System.arraycopy(services, 0, temp, 0, services.length);
        services = temp;
    }

    public boolean add(int index, Service service) {
        if (index < services.length && services[index] == null) {
            services[index] = service;
            size++;
            return true;
        }

        return false;
    }

    public Service get(int index) {
        if (index < services.length) {
            return services[index];
        }

        return null;
    }

    public Service get(String name) {
        for (Service service : services) {
            if (service != null && service.getName().equals(name))
                return service;
        }

        return null;
    }

    public boolean hasService(String name) {
        for (Service service : services) {
            if (service != null && service.getName().equals(name))
                return true;
        }

        return false;
    }

    public Service set(int index, Service service) {
        if (index < services.length) {
            if (services[index] == null)
                size++;

            services[index] = service;
            return services[index];
        }

        return null;
    }

    public Service remove(int index) {
        if (index < services.length) {
            Service service = services[index];

            if (index != services.length - 1) {
                System.arraycopy(services, index + 1, services, index, services.length - index - 1);
            }

            if (services[services.length - 1] != null)
                services[services.length - 1] = null;

            if (service != null)
                size--;

            return service;
        }

        return null;
    }

    public Service remove(String name) {
        for (int i = 0; i < services.length; i++) {
            if (services[i].getName().equals(name)) {

                Service service = services[i];

                if (i != services.length - 1) {
                    System.arraycopy(services, i + 1, services, i, services.length - i - 1);
                }

                if (services[services.length - 1] != null)
                    services[services.length - 1] = null;

                if (service != null)
                    size--;

                return service;
            }
        }

        return null;
    }

    public int size() {
        return size;
    }

    public Service[] getServices() {
        Service[] temp = new Service[size];
        for (int i = 0, j = 0; i < services.length; i++) {
            if (services[i] != null) {
                temp[j] = services[i];
                j++;
            }
        }

        return temp;
    }

    public Service[] sortedServicesByCost() {
        Service[] temp = getServices();

        for (int i = temp.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (temp[j].getCost() > temp[j+1].getCost()) {
                    Service service = temp[j];
                    temp[j] = temp[j+1];
                    temp[j+1] = service;
                }
            }
        }

        return temp;
    }

    public double cost() {
        double cost = 0;
        for (Service service : services) {
            if (service != null)
                cost += service.getCost();
        }

        return cost + SERVICE_CHARGE;
    }

}
