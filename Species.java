import java.io.Serializable;

public class Species implements Serializable {

  final long serialVersionUID = 567;

  private String name;
  private int population;
  private double growthRate;

  public Species() {

  }

  public Species(String newName, int newPopulation, double newGrowthRate) {
    name = newName;
    if (newPopulation >= 0)
      population = newPopulation;
    else {
      System.out.println("ERROR: using a negative population.");
      System.exit(0);
    }
    growthRate = newGrowthRate;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  public void setGrowthRate(double growthRate) {
    this.growthRate = growthRate;
  }

  public String getName() {
    return name;
  }

  public int getPopulation() {
    return population;
  }

  public double getGrowthRate() {
    return growthRate;
  }

  public int predictPopulation(int years) {
    int result = 0;
    double populationAmount = getPopulation();
    int count = years;
    while ((count > 0) && (populationAmount > 0)) {
      populationAmount = (populationAmount + (getGrowthRate() / 100) * populationAmount);
      count--;
    }
    if (populationAmount > 0)
      result = (int) populationAmount;
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Species) {
      Species species = (Species) o;
      return (this.name.equalsIgnoreCase(species.name)) && (this.population == species.population)
          && (this.growthRate == species.growthRate);
    } else
      return false;
  }

  public String toString() {
    return ("Name = " + name + "\n" + "Population = " + population + "\n" + "Growth rate = " + growthRate + "%");
  }
}
