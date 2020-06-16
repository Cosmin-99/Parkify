package FIS.Project.Parkify.Controllers;

public class Request {
    private String username;
    private String hotel;
    private long spotNo;
    private String zone;
    private String status;

    public Request(String username, String hotel, long spotNo, String zone, String status) {
        this.username=username;
        this.hotel = hotel;
        this.spotNo = spotNo;
        this.zone = zone;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return spotNo == request.spotNo &&
                username.equals(request.username) &&
                hotel.equals(request.hotel) &&
                zone.equals(request.zone) &&
                status.equals(request.status);
    }

    @Override
    public String toString() {
        return "Request{" +
                "username='" + username + '\'' +
                ", hotel='" + hotel + '\'' +
                ", spotNo=" + spotNo +
                ", zone='" + zone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public long getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(long spotNo) {
        this.spotNo = spotNo;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
