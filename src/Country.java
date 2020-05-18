import java.util.Objects;

class Country {
    private String code;
    private String name;
    private String population;

    public Country(String code, String name, String population) {
        this.code = code;
        this.name = name;
        this.population = population;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(code, country.code) &&
                Objects.equals(name, country.name) &&
                Objects.equals(population, country.population);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, population);
    }

    @Override
    public String toString() {
        return name + " (" + code + ") ma " + population + " ludności";
    }
}
