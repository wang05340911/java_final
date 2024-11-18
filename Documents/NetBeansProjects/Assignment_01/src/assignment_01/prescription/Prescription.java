package assignment_01.prescription;

import java.util.Date;

/**
 * 
 * The Prescription class calculates and stores details related to a patient's prescription 
 * according to business rules, including daily doses, duration, disease type, surgery date, 
 * and follow-up information.
 *
 */


public class Prescription {
		
	
	long dailyDosageCount;
	long duration;
	String diseaseType;
	Date surgeryDate;
	String riskFactor;
	boolean isFastingRequired;
	Date followUpDate;
	
    /**
        * Parameterized constructor for creating a prescription for medication treatment.
        * 
        * @param age The age of the patient.
        * @param diseaseType The type of disease being treated.
     */
    public Prescription(long age, String diseaseType) {
        this.diseaseType = diseaseType;
        setMedicationDetails(age, diseaseType);
    }

    /**
     * Parameterized constructor for creating a prescription for surgery treatment.
     * 
     * @param age The age of the patient.
     * @param surgeryDate The date of the surgery.
     * @param diseaseType The type of disease being treated.
     */
    public Prescription(long age, Date surgeryDate, String diseaseType) {
        this.surgeryDate = surgeryDate;
        this.diseaseType = diseaseType;
        setSurgeryDetails(age);
    }

    /**
     * Sets medication details such as daily dosage count and duration 
     * based on the patient's age and disease type.
     * 
     * @param age The age of the patient.
     * @param diseaseType The type of disease being treated.
     */
 
   
    private void setMedicationDetails(long age, String diseaseType) {
        
        if (age < 6) {
            this.dailyDosageCount = 1;  // CHILD
                                    
        } else if (age <= 18) {
            this.dailyDosageCount = 2;  // YOUTH
                                
        } else {
            this.dailyDosageCount = 3;  // ADULT
                        
        }
        

         if (diseaseType.equalsIgnoreCase("Chronic")) {
            this.duration = 180;                    // 180 days for chronic conditions
        } 
        if (diseaseType.equalsIgnoreCase("Acute")) {
            this.duration = 7;                          // 7 days for acute conditions
        } 
        if(diseaseType.equalsIgnoreCase("Infection")){
            this.duration = 14;                            //14 days for Infection
        } 
    }

    
    /**
     * Sets surgery details, including risk factor, fasting requirements, 
     * and follow-up date based on the patient's age.
     * 
     * @param age The age of the patient.
     */

    private void setSurgeryDetails(long age) {
        if (age < 6) {
            this.riskFactor = "High";
            this.isFastingRequired = false; 
            this.followUpDate = addDays(new Date(), 1); // Next day follow-up
        } else if (age <= 18) {
            this.riskFactor = "Medium";
            this.isFastingRequired = true; // Fasting required
            this.followUpDate = addDays(new Date(), 7); // One week follow-up
        } else {
            this.riskFactor = "Low";
            this.isFastingRequired = true; // Fasting required
            this.followUpDate = addDays(new Date(), 30); // One month follow-up
        }
    }

    /**
     * Adds a specified number of days to a given date.
     * 
     * @param date The initial date.
     * @param days The number of days to add.
     * @return A new Date object with the added days.
     */
    private Date addDays(Date date, int days) {
        long milliseconds = date.getTime();
        long newMilliseconds = milliseconds + (days * 24 * 60 * 60 * 1000L);
        return new Date(newMilliseconds);
    }

    public long getDuration(){
        return this.duration;
    }
    /**
     * Retrieves the risk factor associated with the patient's surgery.
     * 
     * @return A String representing the risk factor.
     */
    public String getRiskFactor() {
        return this.riskFactor;
    }
         
    public String getDiseaseType(){
        return this.diseaseType;
            }
    
    public void setDiseaseType(){
        
    }
     /**
     * Displays the details of the prescription, including daily dosage and duration.
     * 
     * @return A String containing the prescription details.
     */
    public String displayPrescriptionDetails() {
    StringBuilder details = new StringBuilder();
    
    details.append("Prescription Details:\n");
    details.append("Daily Dosage: ").append(dailyDosageCount).append(" times per day\n");
    details.append("Duration: ").append(duration).append(" days\n"); 
    return details.toString();
}
    /**
     * Displays the details of the surgery, including surgery date, risk factor, 
     * fasting requirements, and follow-up date.
     * 
     * @return A String containing the surgery details.
     */
    public String displaySurgeryDetails(){
    StringBuilder surgery = new StringBuilder();
    surgery.append("Surgery Details:\n");
    surgery.append("Surgery Date: ").append(surgeryDate != null ? surgeryDate.toString() : "N/A").append("\n");
    surgery.append("Risk Factor: ").append(riskFactor).append("\n");
    surgery.append("Fasting Required: ").append(isFastingRequired ? "Yes" : "No").append("\n");
    surgery.append("Follow Up Date: ").append(followUpDate).append("\n");
    
    return surgery.toString();
        
    }
    
}