package db;

public class Country {
    private Long id;
    private String name;
    private String code;
    private int population;

    public Country() {
    }

    public Country(Long id, String name, String code, int population) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.population = population;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    }

