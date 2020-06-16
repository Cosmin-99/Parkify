package FIS.Project.Parkify.Controllers;

public class Spot {
    private long number;
    private long floor;
    private String section;
    private double price;
    private String availability;

    public Spot(long number,long floor, String section, double price, String availability) {
        this.number=number;
        this.floor=floor;
        this.section=section;
        this.price=price;
        this.availability=availability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spot spot = (Spot) o;
        return number == spot.number &&
                floor == spot.floor &&
                section.equals(spot.section) &&
                Double.compare(spot.price, price) == 0 &&
                availability.equals(spot.availability);
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
