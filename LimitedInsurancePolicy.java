public class LimitedInsurancePolicy extends InsurancePolicy {
  
  /* stores the boolean value for if the policy has an annual limit or not */
  private boolean hasAnnualLimit = false;
  
  /* stores the double value for the annual limit */
  private double annualLimit = 0;
  
  /* stores the boolean value for if the policy has a lifetime limit or not */
  private boolean hasLifetimeLimit = false;
  
  /* stores the double value for the lifetime limit */
  private double lifetimeLimit = 0;
  
  /* initializes the corresponding instance fields using the LimitedInsurancePolicy constructor and parent constructor */
  public LimitedInsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, double actuarialValue, boolean hasAnnualLimit, double annualLimit, boolean hasLifetimeLimit, double lifetimeLimit) {
    super(policyNumber, expirationDate, copay, deductible, actuarialValue);
    this.hasAnnualLimit = hasAnnualLimit;
    this.annualLimit = annualLimit;
    this.hasLifetimeLimit = hasLifetimeLimit;
    this.lifetimeLimit = lifetimeLimit;
  }
  
  /* initializes the corresponding (extra) instance fields using the overloaded LimitedInsurancePolicy constructor */
  public LimitedInsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, double actuarialValue, boolean hasAnnualLimit, double annualLimit, boolean hasOutOfPocketLimit, double outOfPocketLimit, boolean hasLifetimeLimit, double lifetimeLimit, double expectedTenYearBenefit, double profitMargin, InsurancePolicy supplementalInsurance) {
    super(policyNumber, expirationDate, copay, deductible, actuarialValue, hasOutOfPocketLimit, outOfPocketLimit, expectedTenYearBenefit, profitMargin, supplementalInsurance);
    this.hasAnnualLimit = hasAnnualLimit;
    this.annualLimit = annualLimit;
    this.hasLifetimeLimit = hasLifetimeLimit;
    this.lifetimeLimit = lifetimeLimit;
  }
  
  /* if the policy is given a true boolean value for hasAnnualLimit, the inputted parameter for the annual limit will be initialized; otherwise
   * if the policy is given a false boolean value for hasAnnualLimit does not have an annual limit, the annual limit is initialized to 0 */
  public void setAnnualLimit(boolean hasAnnualLimit, double annualLimit) {
    this.hasAnnualLimit = hasAnnualLimit;
    if (this.hasAnnualLimit() == true) {
      this.annualLimit = annualLimit;
    }
    else {
      this.annualLimit = 0;
    }
  }
  
  /* if the policy can have an annual limit, true is returned
   * if the policy cannot have an annual limit, false is returned */
  public boolean hasAnnualLimit() {
    if (hasAnnualLimit == true) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /* if the policy can have an annual limit, the value of the annual limit is returned
   * if not, 0 is returned */
  public double getAnnualLimit() {
    if (this.hasAnnualLimit() == true) {
      return annualLimit;
    }
    else {
      return 0;
    }
  }
  
  /* initializes the boolean value of hasLifetimeLimit and if the value is true; the policy can hold a
   * lifetimeLimit value that will be initialized as the inputted second parameter; if false,
   * the lifetimeLimit is initialized to 0 */
  public void setLifetimeLimit(boolean hasLifetimeLimit, double lifetimeLimit) {
    this.hasLifetimeLimit = hasLifetimeLimit;
    if(this.hasLifetimeLimit() == true) {
      this.lifetimeLimit = lifetimeLimit;
    }
    else {
      this.lifetimeLimit = 0;
    }
  }
  
  /* checks if the policy has a lifetime limit by checking the hasLifetimeLimit boolean; if true, it can
   * have a lifetime limit; but if false, it cannot hold a lifetime limit */
  public boolean hasLifetimeLimit() {
    if (hasLifetimeLimit == true) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /* returns the value of the lifetime limit stored in "lifetimeLimit" instance field */
  public double getLifetimeLimit() {
    if (this.hasLifetimeLimit() == true) {
      return lifetimeLimit;
    }
    else {
      return 0;
    }
  }
  
  /* if the policy has an annual limit and the sum of the claim and the yearly benefit is greater than
   * the annual limit, the claim is reduced by the difference between the annual limit and the sum of the claim
   * and yearly benefit; if not, the original claim amount is returned */
  public double applyAnnualLimit(double claim) {
    if (this.hasAnnualLimit() == true && claim + this.getYearlyBenefit() > this.getAnnualLimit()) {
      claim = claim + (this.getAnnualLimit() - (claim + this.getYearlyBenefit()));
      return claim;
    }
    else {
      return claim;
    }
  }
  
  /* if the policy has a lifetime limit and the sum of the claim and lifetime benefit are greater than the
   * lifetime limit, the claim is reduced by the difference between the lifetime limit and the sum of the
   * claim and lifetime benefit (excess) ; if not, the original claim amount is returned */
  public double applyLifetimeLimit(double claim) {
    if (this.hasLifetimeLimit() == true && claim + this.getLifetimeBenefit() > this.getLifetimeLimit()) {
      claim = claim + (this.getLifetimeLimit() - (claim + this.getLifetimeBenefit()));
      return claim;
    }
    else {
      return claim;
    }
  }
  /* the method takes the inputted "claim" parameter and checks if it has expired; if it has expired,
   * it returns the inputted "claim" parameter; if not, it reduces the "claim" parameter by the 
   * "copay", "deductible", and "actuarialValue"; the claim is then stored as "benefit" and the difference between the
   * initial "claim" and the benefit is the "outOfPocketCost"; the "outOfPocketCost" is reduced by applying
   * the supplemental insurance (method); if the insurance policy can hold an "outOfPocketLimit" and it excreeds the
   * "yearlyOutOfPocketCost", the "outOfPocketCost" local variable is reduced by the excess and then added to "benefit"; 
   * if the sum of the benefit and yearlybenefit are greater than the annual limit, the benefit is reduced by
   * the excess; if the sum of the benefit and the lifetime benefit are greater than the lifetime limit, the
   * benefit is reduced by the excess; the difference between the initial benefit and reduced benefit, stored as
   * "additionalOutOfPocketCost", is then added to the yearly benefit and lifetime benefit and then the sum of the
   * "outOfPocketCost" and the "additionalOutOfPocketCost" is returned */
  public double processClaim(double claim, Date date) {
    double initClaim = claim;
    if (date.compareTo(this.getExpirationDate()) > 0) {
      return claim;
    }
    else { // policy is not expired (date ==, date1 < date2)
      claim = this.applyCopay(claim);
      claim = this.applyDeductible(claim);
      claim = this.applyActuarialValue(claim);
      double benefit = claim;
      double outOfPocketCost = initClaim - benefit;
      if (this.getSupplementalInsurance() != null) {
        outOfPocketCost = outOfPocketCost - this.applySupplementalInsurance(outOfPocketCost, date);
      }
      if (this.hasOutOfPocketLimit() == true && (outOfPocketCost + this.getYearlyOutOfPocketCost() > this.getOutOfPocketLimit())) {
        // can set a field to remember the calculation if need be
        outOfPocketCost = outOfPocketCost - ((outOfPocketCost + this.getYearlyOutOfPocketCost()) - this.getOutOfPocketLimit());
      }
      double initialBenefit = benefit; // stores the unreduced benefit value
      if (benefit + this.getYearlyBenefit() > this.getAnnualLimit()) {
        benefit = this.applyAnnualLimit(benefit);
      }
      if (benefit + this.getLifetimeBenefit() > this.getLifetimeLimit()) {
        benefit = this.applyLifetimeLimit(benefit);
      }
      double additionalOutOfPocketCost = initialBenefit - benefit; // stores the difference between the initial benefit value and the reduced benefit value
      this.setYearlyBenefit(this.getYearlyBenefit() - additionalOutOfPocketCost);
      this.setLifetimeBenefit(this.getLifetimeBenefit() - additionalOutOfPocketCost);
      if (this.getSupplementalInsurance() != null) {
        additionalOutOfPocketCost = this.applySupplementalInsurance(additionalOutOfPocketCost, date);
      }
      this.setYearlyOutOfPocketCost(this.getYearlyOutOfPocketCost() + additionalOutOfPocketCost);
      return outOfPocketCost + additionalOutOfPocketCost;
    }
  }
  
  /* returns the value of the expected ten year benefit but if the policy has a lifetime limit and the 
   * expected ten year benefit is greater than the difference between the lifetime limit and lifetime benefit,
   * the expected ten year benefit is reduced by the excess and the new value is returned*/
  public double getExpectedTenYearBenefit() {
    if (this.hasLifetimeLimit() == true && super.getExpectedTenYearBenefit() > (this.getLifetimeLimit() - this.getLifetimeBenefit())) {
      return super.getExpectedTenYearBenefit() - (super.getExpectedTenYearBenefit() - (this.getLifetimeLimit() - this.getLifetimeBenefit()));
    }
    else {
      return super.getExpectedTenYearBenefit();
    }
  }
}
      