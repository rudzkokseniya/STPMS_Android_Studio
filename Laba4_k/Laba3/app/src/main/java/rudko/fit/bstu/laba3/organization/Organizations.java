package rudko.fit.bstu.laba3.organization;

public enum Organizations {
    EPAM(1,"Effective Programming for America"),ITechArt(5,"iTechArt Group"),Wargaming(3,"Wargaming.net");
    private Integer Rate;
    private String Fullname;
    Organizations(int r,String s){
        this.Rate = r;
        this.Fullname=s;
    }

    public String getname() {
        return this.name();
    }

    public String getOrganizations(){ return "FullName:"+this.Fullname+"; Rating in Belarus:"+this.Rate;}
}
