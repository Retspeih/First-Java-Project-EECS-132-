public class InsurancePolicy extends Object {
  
  /* stores the String value for the policy number */
  private String policyNumber = "";
  
  /* stores the double value for the copay */
  private double copay = 0;
  
  /* stores the double value for the deductible */
  private double deductible = 0;
  
  /* stores the double value for the amount applied to the deductible */
  private double amountAppliedToDeductible = 0;
  
  /* stores the double value for the actuarial value */
  private double actuarialValue = 0;
  
  /* stores the boolean value for if the policy has an out of pocket limit or not */
  private boolean hasOutOfPocketLimit = false;
  
  /* stores the double value for the out of pocket limit */
  private double outOfPocketLimit = 0;
  
  /* stores the double value for the yearly benefit */
  private double yearlyBenefit = 0;
  
  /* stores the double value for the lifetime benefit */
  private double lifetimeBenefit = 0;
  
  /* stores the instance field supplementalInsurance as a InsurancePolicy reference type */
  private InsurancePolicy supplementalInsurance = null;
  
  /* stores the instance field expirationDate as a Date reference type */
  private Date expirationDate = null;
  
  /* stores the double value for the premium */
  private double premium = 0;
  
  /* stores the double value for the profit margin */
  private double profitMargin = 0;
  
  /* stores the double value for the expected ten year benefit */
  private double expectedBenefit = 0;
  
  /* stores the double value for the yearly out of pocket cost */
  private double yearlyOutOfPocketCost = 0;
  
  /* initializes the corresponding instance fields using the InsurancePolicy constructor */
  public InsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, double actuarialValue) {
    this.policyNumber = policyNumber;
    this.expirationDate = expirationDate;
    this.copay = copay;
    this.deductible = deductible;
    this.actuarialValue = actuarialValue;
  }
  
  public InsurancePolicy(String policyNumber, Date expirationDate, double copay, double deductible, double actuarialValue, boolean hasOutOfPocketLimit, double outOfPocketLimit, double expectedTenYearBenefit, double profitMargin, InsurancePolicy supplementalInsurance) {
    this.policyNumber = policyNumber;
    this.expirationDate = expirationDate;
    this.copay = copay;
    this.deductible = deductible;
    this.actuarialValue = actuarialValue;
    this.hasOutOfPocketLimit = hasOutOfPocketLimit;
    this.outOfPocketLimit = outOfPocketLimit;
    this.expectedBenefit = expectedTenYearBenefit;
    this.profitMargin = profitMargin;
    this.supplementalInsurance = supplementalInsurance;
  }
  
  /* returns the policy number */
  public String getPolicyNumber() {
    return policyNumber;
  }
  
  /* set the "copay" amount as a double value */
  public void setCopay(double copay) {
    this.copay = copay;
  }
  
  /* return the "copay" amount */
  public double getCopay() {
    return copay;
  }
  
  /* set the "deductible" amount as a double value */
  public void setDeductible(double deductible) {
    this.deductible = deductible;
  }
  
  /* return the "deductible" amount */
  public double getDeductible() {
    return deductible;
  }
  
  /* assigns the "amountAppliedToDeductible" instance field a double value */
  public void setAmountAppliedToDeductible(double amountAppliedToDeductible) {
    this.amountAppliedToDeductible = amountAppliedToDeductible;
  }
  
  /* return the amount applied to the deductible for the fiscal year */
  public double getAmountAppliedToDeductible() {
    return amountAppliedToDeductible;
  }
  
  /* set the actuarial value for the policy which shows
   * the percentage of claims that the policy may cover */
  public void setActuarialValue(double actuarialValue) {
    this.actuarialValue = actuarialValue;
  }
  
  public double getActuarialValue() {
    return actuarialValue;
  }
  
  
  /* sets the out-of-pocket limit for the policy only if the policy
   * allows it with a value of "true", if the policy does
   * not allow an out-of-pocket limit, "false", then the out-of-pocket
   * limit is set to 0 */
  public void setOutOfPocketLimit(boolean hasOutOfPocketLimit, double outOfPocketLimit) {
    this.hasOutOfPocketLimit = hasOutOfPocketLimit;
    if (hasOutOfPocketLimit == true) {
      this.outOfPocketLimit = outOfPocketLimit;
    }
    else {
      this.outOfPocketLimit = 0;
    }
  }
  
  /* returns "true" if the policy has an out-of-pocket limit
   * and "false" if it does not */
  public boolean hasOutOfPocketLimit() {
    if (hasOutOfPocketLimit == true) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /* returns the amount for the out-of-pocket limit allowed by the policy */
  public double getOutOfPocketLimit() {
    return outOfPocketLimit;
  }
  
  /* assigns the "yearlyOutOfPocketCost" instance field a double value */
  public void setYearlyOutOfPocketCost(double yearlyOutOfPocketCost) {
    this.yearlyOutOfPocketCost = yearlyOutOfPocketCost;
  }
  
  /* assigns the "yearlyBenefit" instance field a double value */
  public void setYearlyBenefit(double yearlyBenefit) {
    this.yearlyBenefit = yearlyBenefit;
  }
  
  /* returns the amount the policy has paid so far this year */
  public double getYearlyBenefit() {
    return yearlyBenefit;
  }
  
  /* assigns the "lifetimeBenefit" instance field a double value */
  public void setLifetimeBenefit(double lifetimeBenefit) {
    this.lifetimeBenefit = lifetimeBenefit;
  }
  
  /* return the amount the policy has paid so far in total */
  public double getLifetimeBenefit() {
    return lifetimeBenefit;
  }
  
  /* sets a supplemental insurance policy for the policy */
  public void setSupplementalInsurance(InsurancePolicy policy) {
    this.supplementalInsurance = policy;
  }
  
  /* returns the address in memory of the supplemental insurance policy, if one exists */
  public InsurancePolicy getSupplementalInsurance() {
    return supplementalInsurance;
  }
  
  /* return the ending date of the policy (change return type)*/
  public Date getExpirationDate() {
    return expirationDate;
  }
  
  /* return the "premium" value stored in memory */
  public double getPremium() {
    return premium;
  }
  
  /* sets the profit margin amount as a double */
  public void setProfitMargin(double profitMargin) {
    this.profitMargin = profitMargin;
  }
  
  /* returns the "profitMargin" instance field value as a double */
  public double getProfitMargin() {
    return profitMargin;
  }
  
  /* assigns the inputted parameter value to the "expectedBenefit" instance field */
  public void setExpectedTenYearBenefit(double expectedBenefit) {
    this.expectedBenefit = expectedBenefit;
  }
  
  /* returns the "expectedBenefit" instance field value as a double */
  public double getExpectedTenYearBenefit() {
    return expectedBenefit;
  }
  
  /* takes the inputted "claim" parameter and subtracts from it the "copay" instance field value */
  public double applyCopay(double claim) {
    claim = claim - this.getCopay();
    return claim;
  }
  
  /* when run, the method checks if the "amountAppliedToDeductible" is less the the "deductible", and if
   * it is, the claim is reduced by the lesser of the inputted "claim" parameter or the difference between the
   * "amountAppliedToDeductible" and "deductible" instance fields; if not, the claim is returned */
  public double applyDeductible(double claim) {
    if (this.getAmountAppliedToDeductible() < this.getDeductible()) {
      claim = claim - Math.min(claim, (this.getDeductible() - this.getAmountAppliedToDeductible()));
      return claim;
    }
    else {
      return claim;
    }
  }
  
  /* returns the inputted parameter "claim" multiplied by the "actuarialValue" instance field */
  public double applyActuarialValue(double claim) {
    return claim * this.getActuarialValue();
  }
  
  /* if there is a supplemental insurance, the "processClaim()" method is invoked for the
   * supplemental insurance policy */
  public double applySupplementalInsurance(double claim, Date date) {
    if (this.getSupplementalInsurance() != null) {
      this.getSupplementalInsurance().processClaim(claim, date);
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
   * the "benefit" is then added to the "yearlyBenefit" and "lifetimeBenefit"; the "outOfPocketCost" is then added to the
   * "yearlyOutOfPocketCost" and the outOfPocketCost is returned */
  public double processClaim(double claim, Date date) {
    double initClaim = claim; // we need to remember the claim's original value for later calculations
    if (date.compareTo(this.getExpirationDate()) > 0) {
      return claim;
    }
    else { // policy is not expired (date ==, date1 < date2)
      claim = this.applyCopay(claim);
      claim = this.applyDeductible(claim);
      claim = this.applyActuarialValue(claim);
      double benefit = claim; // benefit stores the reduced value of claim
      double outOfPocketCost = initClaim - benefit; // this stores the difference between the initial value of the claim and the reduced value of claim
      if (this.getSupplementalInsurance() != null) {
        outOfPocketCost = outOfPocketCost - this.applySupplementalInsurance(outOfPocketCost, date);
      }
      if (this.hasOutOfPocketLimit() == true && (outOfPocketCost + this.yearlyOutOfPocketCost > this.getOutOfPocketLimit())) {
        // can set a field to remember the calculation if need be
        outOfPocketCost = outOfPocketCost - ((outOfPocketCost + this.yearlyOutOfPocketCost) - this.getOutOfPocketLimit());
      }
      this.setYearlyBenefit(this.getYearlyBenefit() + benefit);
      this.setLifetimeBenefit(this.getLifetimeBenefit() + benefit);
      this.setYearlyOutOfPocketCost(this.yearlyOutOfPocketCost + outOfPocketCost);
      return outOfPocketCost;
    }
  }
  
  /* the "amountAppliedToDeductible", "yearlyBenefit", and "yearlyOutOfPocketCosts" instance fields are
   * all set to 0; the "expectedTenYearBenefit" instance field is readjusted by adding the unmodified
   * "yearlyBenefit" instance field to 90% of the current "expectedTenYearBenefit" and the "date" object
   * is altered by increasing "year" by 1 */
  public void renewPolicy() {
    this.setExpectedTenYearBenefit(this.getYearlyBenefit() + (0.90) * this.getExpectedTenYearBenefit());
    this.setAmountAppliedToDeductible(0.0);
    this.setYearlyBenefit(0.0);
    this.setYearlyOutOfPocketCost(0.0);
    this.getExpirationDate().setYear(this.getExpirationDate().getYear() + 1);
  }
  
  /* returns a value that is "x" percent more than the "expectedTenYearBenefit" instance field divided by 10
   * the "x" local variable is initialized to the value stored in the "profitMargin" instance field*/
  public double premium() {
    double y = this.getExpectedTenYearBenefit() / 10; // stores the value of the expected ten year benefit divided by 10
    double x = this.getProfitMargin(); // stores the value of the profit margin for calculation ease
    return (y * x + y);
  }
  
  /* computes the sum of the premium for the current policy and adds the premium of any of its
   * supplemental insurance policies */
  public double totalPremium() {
    return this.getPremium() + this.getSupplementalInsurance().getPremium();
  }
  
  /* returns the value stored in the "yearlyOutOfPocketCost" instance field */
  public double getYearlyOutOfPocketCost() {
    return this.yearlyOutOfPocketCost;
  }
  
  /* checks if two policies are equivalent by comparing policy numbers and expiration date */
  public boolean equals(InsurancePolicy policy) {
    if (this.getPolicyNumber() == policy.getPolicyNumber() && this.getExpirationDate().getDay() == policy.getExpirationDate().getDay() && this.getExpirationDate().getMonth() == policy.getExpirationDate().getMonth() && this.getExpirationDate().getYear() == policy.getExpirationDate().getYear()) {
      return true;
    }
    else {
      return false;
    }
  }
}
  