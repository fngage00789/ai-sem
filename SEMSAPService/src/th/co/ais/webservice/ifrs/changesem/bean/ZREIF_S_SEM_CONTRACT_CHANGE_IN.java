/**
 * ZREIF_S_SEM_CONTRACT_CHANGE_IN.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.ifrs.changesem.bean;


/**
 * SEM Contract Change Interface Input
 */
public class ZREIF_S_SEM_CONTRACT_CHANGE_IN  implements java.io.Serializable {
    /* Local file for upload/download */
    private java.lang.String FILENAME;

    /* Refference ID */
    private java.lang.String REFERENCE_ID;

    /* Single-Character Indicator */
    private java.lang.String ACTIVITY;

    /* Company Code */
    private java.lang.String COMP_CODE;

    /* Contract Number */
    private java.lang.String CONTRACT_NO;

    /* Company code of main contract */
    private java.lang.String COMPANY_CODE_MAIN;

    /* Number of old contract */
    private java.lang.String MAIN_CONTRACT_NO;

    /* Number of old contract */
    private java.lang.String OLD_CONTRACT_NO;

    /* Contract Type */
    private java.lang.String CONTRACT_TYPE;

    /* Object Description */
    private java.lang.String OBJECT_DESC;

    /* Contract name */
    private java.lang.String CONTRACT_NAME;

    /* Contract conclusion Date */
    private java.lang.String CONTRACT_CONCLUSION_DATE;

    /* Contract Start date */
    private java.lang.String DATE_CONTRACT_START;

    /* Contract End Date */
    private java.lang.String DATE_FIRST_CONTRACT_END;

    /* Authorization Group */
    private java.lang.String AUTHORIZATION_GROUP;

    /* Industry */
    private java.lang.String INDUSTRY;

    /* Person Responsible */
    private java.lang.String PERSON_RESPONSIBLE;

    /* Cash Flow Generated Starting On */
    private java.lang.String CASH_FLOW_STARTING_ON;

    /* First Posting From */
    private java.lang.String FIRST_POSTING_FROM;

    /* Currency for Contract */
    private java.lang.String CURRENCY_FOR_CONTRACT;

    /* Type of Renewal of Real Estate Contract */
    private java.lang.String TYPE_OF_RENEWAL;

    /* Renewal Rule */
    private java.lang.String RENEWAL_RULE;

    /* sequence no */
    private java.lang.String SEQUENCE_NO;

    /* Number of Renewals */
    private java.lang.String NO_OF_RENEWALS;

    /* Contract Renewed for Number of Years */
    private java.lang.String CONTRACT_RENEWED_YEARS;

    /* Contract Renewed for Number of Months */
    private java.lang.String CONTRACT_RENEWED_MONTHS;

    /* Contract Renewed for Number of Days */
    private java.lang.String CONTRACT_RENEWED_DAYS;

    /* Type of Automatic Renewal */
    private java.lang.String TYPE_OF_AUTOMATIC_RENEWAL;

    /* Renewal Execution */
    private java.lang.String RENEWAL_EXECUTION;

    /* Term Number */
    private java.lang.String TERM_NO;

    /* Payment Method */
    private java.lang.String PAYMENT_METHOD;

    /* Pmt meth.supl. */
    private java.lang.String PMT_METHSUPL;

    /* Individ. Set */
    private java.lang.String INDIVID_SET;

    /* Payment block key */
    private java.lang.String PAYMENT_BLOCK_KEY;

    /* Terms of Payment Key */
    private java.lang.String TERMS_OF_PAYMENT_KEY;

    /* Key for House Bank */
    private java.lang.String KEY_FOR_HOUSE_BANK;

    /* Bank Details ID */
    private java.lang.String BANK_DETAILS_ID;

    /* Note to Payee */
    private java.lang.String NOTE_TO_PAYEE;

    /* Dunning Area */
    private java.lang.String DUNNING_AREA;

    /* Dunning Block */
    private java.lang.String DUNNING_BLOCK;

    /* Account Determination Value */
    private java.lang.String ACCOUNT_DETERMINATION;

    /* Tax Type */
    private java.lang.String TAX_TYPE;

    /* Tax Group */
    private java.lang.String TAX_GROUP;

    /* Business Partner Number */
    private java.lang.String BUSINESS_PARTNER_NO;

    /* Term Number */
    private java.lang.String TERM_NO1;

    /* Number of Frequency Units of Period */
    private java.lang.String FREQUENCY;

    /* Frequency Unit */
    private java.lang.String FREQUENCY_UNIT;

    /* Start of Frequency for Daily, Monthly, and Yearly Frequency */
    private java.lang.String STARTING_MONTH;

    /* Payment Form (Period Start, Mid-Period, In Arrears, Example) */
    private java.lang.String PAYMENT_FORM;

    /* Pro Rata Method */
    private java.lang.String PRORATED;

    /* Calculation method for time-dependent periods */
    private java.lang.String CALCULATE_METHOD;

    /* Factory Calendar */
    private java.lang.String FACTORY_CALENDAR;

    /* Business Partner Number */
    private java.lang.String PARTNER_DAT;

    /* Business Partner: Role */
    private java.lang.String ROLE_TYPE;

    /* Date of Start of Relationship */
    private java.lang.String DATE_START_RELATIONSHIP;

    /* Date of End of Relationship */
    private java.lang.String DATE_END_RELATIONSHIP;

    /* Address Type */
    private java.lang.String ADDRESS_TYPE;

    /* Equivalence Number */
    private java.lang.String CONDITION_SPLIT;

    /* Condition Type */
    private java.lang.String CONDITION_TYPE;

    /* Conditions - External Purpose */
    private java.lang.String CONDITION_PURPOSE;

    /* Date from when condition is valid */
    private java.lang.String DATE_FROM_CONDITION;

    /* Date up to when condition is valid */
    private java.lang.String DATE_UP_TO_CONDITION;

    /* Currency of condition item */
    private java.lang.String CURRENCY_CONDITION;

    /* Number of Posting Term */
    private java.lang.String NO_POSTING_TERM;

    /* Number of Frequency Term */
    private java.lang.String NO_FREQUENCY_TERM;

    /* Number of Organizational Assignment Term */
    private java.lang.String NO_ORGANIZATIONAL_TERM;

    /* Complete Object Identification, for Example BE 1000/123 */
    private java.lang.String COST_CENTER;

    /* Profit Center */
    private java.lang.String PROFIT_CENTER;

    /* Calculation Formula */
    private java.lang.String CALCULATION_FORMULA;

    /* Unit Price */
    private java.math.BigDecimal CURRENCY_UNIT_PRICE;

    /* Distribution Formula */
    private java.lang.String DISTRIBUTION_FORMULA;

    /* Dummy */
    private java.lang.String CONDITIONS_EXTERNAL_PURPOSE;

    /* Condition Is One-Time Condition */
    private java.lang.String CONDITION_ONE_TIME1;

    /* Statistical or Informational Condition */
    private java.lang.String STATISTICAL_INFO_CONDITION1;

    /* First Posting From */
    private java.lang.String POSTING_START_DATE_CONDITION;

    /* Dummy */
    private java.lang.String NO_OF_WHT_TERM;

    /* Different Due Date of One-Time Condition */
    private java.lang.String DIFFERENT_DUE_DATE_ONE_TIME;

    /* Grading Term in Months */
    private java.math.BigInteger GRADING_TERM_IN_MONTHS;

    /* Grading Interval in Months */
    private java.math.BigInteger GRADING_INTERVAL_MONTHS;

    /* Grading Percent Increase */
    private java.math.BigDecimal GRADING_PERCENT_INCREASE;

    /* Grading Absolute Increase */
    private java.math.BigInteger GRADING_ABSOLUTE_INCREASE;

    /* Business Transaction */
    private java.lang.String CONTRACT_STATUS;

    /* Valuation Rule */
    private java.lang.String VALUATION_RULE;

    /* ID of Object */
    private java.lang.String OBJECT_ID;

    /* Business Object Type of Object */
    private java.lang.String OBJECT_TYPE;

    /* Object Valid From */
    private java.lang.String OBJECT_VALID_FROM;

    /* Object Valid To */
    private java.lang.String OBJECT_VALID_TO;

    /* Start of Consideration */
    private java.lang.String START_DATE_OF_CONSIDERATION;

    /* First Posting From */
    private java.lang.String FIRST_POSTING_FROM1;

    /* Classification */
    private java.lang.String CLASSIFICATION;

    /* Interest Rate */
    private java.math.BigDecimal INTEREST_RATE;

    /* Number of Frequency Term */
    private java.lang.String FREQUENCY_TERM;

    /* Distribution Formula */
    private java.lang.String DISTRIBUT_FORMULA;

    /* Untypified Parameter for a Distribution Formula */
    private java.lang.String DISTRIB_FORMULA_PARAMETER;

    private java.lang.String PROBABLE_END;

    /* End of Usage RoU */
    private java.lang.String END_OF_USAGE_ROU;

    /* Status Reason for Valuation Rule */
    private java.lang.String VALUATION_STATUS;

    /* Valuation Behavior */
    private java.lang.String VALUATION_BEHAVIOR;

    /* Company Code */
    private java.lang.String COMPANY_CODE;

    /* ID of Object */
    private java.lang.String ASSET;

    /* Subnumber */
    private java.lang.String SUBNO;

    /* Object Description */
    private java.lang.String OBJECT_DESCRIPTION;

    /* Business Object Type of Object */
    private java.lang.String ACCTASGOBJTYPE;

    /* Absolute Start */
    private java.lang.String ABSOLUTE_START;

    /* Absolute End */
    private java.lang.String ABSOLUTE_END;

    /* Condition Valuation Property */
    private java.lang.String COND_VAL_PROPERTY;

    /* Condition Consideration */
    private java.lang.String COND_CONSIDERATION;

    /* Indicator: Consider Condition? */
    private java.lang.String CONSIDER_CONDITION;

    /* Percentage */
    private java.lang.String PERCENTAGE;

    /* Absolute Share */
    private java.lang.String ABSOLUTE_SHARE;

    /* Currency for Contract */
    private java.lang.String CURRENCY;

    /* Conditions - External Purpose */
    private java.lang.String CONDITION_PURPOSE1;

    /* Unit Price */
    private java.math.BigDecimal UNIT_PRICE1;

    public ZREIF_S_SEM_CONTRACT_CHANGE_IN() {
    }

    public ZREIF_S_SEM_CONTRACT_CHANGE_IN(
           java.lang.String FILENAME,
           java.lang.String REFERENCE_ID,
           java.lang.String ACTIVITY,
           java.lang.String COMP_CODE,
           java.lang.String CONTRACT_NO,
           java.lang.String COMPANY_CODE_MAIN,
           java.lang.String MAIN_CONTRACT_NO,
           java.lang.String OLD_CONTRACT_NO,
           java.lang.String CONTRACT_TYPE,
           java.lang.String OBJECT_DESC,
           java.lang.String CONTRACT_NAME,
           java.lang.String CONTRACT_CONCLUSION_DATE,
           java.lang.String DATE_CONTRACT_START,
           java.lang.String DATE_FIRST_CONTRACT_END,
           java.lang.String AUTHORIZATION_GROUP,
           java.lang.String INDUSTRY,
           java.lang.String PERSON_RESPONSIBLE,
           java.lang.String CASH_FLOW_STARTING_ON,
           java.lang.String FIRST_POSTING_FROM,
           java.lang.String CURRENCY_FOR_CONTRACT,
           java.lang.String TYPE_OF_RENEWAL,
           java.lang.String RENEWAL_RULE,
           java.lang.String SEQUENCE_NO,
           java.lang.String NO_OF_RENEWALS,
           java.lang.String CONTRACT_RENEWED_YEARS,
           java.lang.String CONTRACT_RENEWED_MONTHS,
           java.lang.String CONTRACT_RENEWED_DAYS,
           java.lang.String TYPE_OF_AUTOMATIC_RENEWAL,
           java.lang.String RENEWAL_EXECUTION,
           java.lang.String TERM_NO,
           java.lang.String PAYMENT_METHOD,
           java.lang.String PMT_METHSUPL,
           java.lang.String INDIVID_SET,
           java.lang.String PAYMENT_BLOCK_KEY,
           java.lang.String TERMS_OF_PAYMENT_KEY,
           java.lang.String KEY_FOR_HOUSE_BANK,
           java.lang.String BANK_DETAILS_ID,
           java.lang.String NOTE_TO_PAYEE,
           java.lang.String DUNNING_AREA,
           java.lang.String DUNNING_BLOCK,
           java.lang.String ACCOUNT_DETERMINATION,
           java.lang.String TAX_TYPE,
           java.lang.String TAX_GROUP,
           java.lang.String BUSINESS_PARTNER_NO,
           java.lang.String TERM_NO1,
           java.lang.String FREQUENCY,
           java.lang.String FREQUENCY_UNIT,
           java.lang.String STARTING_MONTH,
           java.lang.String PAYMENT_FORM,
           java.lang.String PRORATED,
           java.lang.String CALCULATE_METHOD,
           java.lang.String FACTORY_CALENDAR,
           java.lang.String PARTNER_DAT,
           java.lang.String ROLE_TYPE,
           java.lang.String DATE_START_RELATIONSHIP,
           java.lang.String DATE_END_RELATIONSHIP,
           java.lang.String ADDRESS_TYPE,
           java.lang.String CONDITION_SPLIT,
           java.lang.String CONDITION_TYPE,
           java.lang.String CONDITION_PURPOSE,
           java.lang.String DATE_FROM_CONDITION,
           java.lang.String DATE_UP_TO_CONDITION,
           java.lang.String CURRENCY_CONDITION,
           java.lang.String NO_POSTING_TERM,
           java.lang.String NO_FREQUENCY_TERM,
           java.lang.String NO_ORGANIZATIONAL_TERM,
           java.lang.String COST_CENTER,
           java.lang.String PROFIT_CENTER,
           java.lang.String CALCULATION_FORMULA,
           java.math.BigDecimal CURRENCY_UNIT_PRICE,
           java.lang.String DISTRIBUTION_FORMULA,
           java.lang.String CONDITIONS_EXTERNAL_PURPOSE,
           java.lang.String CONDITION_ONE_TIME1,
           java.lang.String STATISTICAL_INFO_CONDITION1,
           java.lang.String POSTING_START_DATE_CONDITION,
           java.lang.String NO_OF_WHT_TERM,
           java.lang.String DIFFERENT_DUE_DATE_ONE_TIME,
           java.math.BigInteger GRADING_TERM_IN_MONTHS,
           java.math.BigInteger GRADING_INTERVAL_MONTHS,
           java.math.BigDecimal GRADING_PERCENT_INCREASE,
           java.math.BigInteger GRADING_ABSOLUTE_INCREASE,
           java.lang.String CONTRACT_STATUS,
           java.lang.String VALUATION_RULE,
           java.lang.String OBJECT_ID,
           java.lang.String OBJECT_TYPE,
           java.lang.String OBJECT_VALID_FROM,
           java.lang.String OBJECT_VALID_TO,
           java.lang.String START_DATE_OF_CONSIDERATION,
           java.lang.String FIRST_POSTING_FROM1,
           java.lang.String CLASSIFICATION,
           java.math.BigDecimal INTEREST_RATE,
           java.lang.String FREQUENCY_TERM,
           java.lang.String DISTRIBUT_FORMULA,
           java.lang.String DISTRIB_FORMULA_PARAMETER,
           java.lang.String PROBABLE_END,
           java.lang.String END_OF_USAGE_ROU,
           java.lang.String VALUATION_STATUS,
           java.lang.String VALUATION_BEHAVIOR,
           java.lang.String COMPANY_CODE,
           java.lang.String ASSET,
           java.lang.String SUBNO,
           java.lang.String OBJECT_DESCRIPTION,
           java.lang.String ACCTASGOBJTYPE,
           java.lang.String ABSOLUTE_START,
           java.lang.String ABSOLUTE_END,
           java.lang.String COND_VAL_PROPERTY,
           java.lang.String COND_CONSIDERATION,
           java.lang.String CONSIDER_CONDITION,
           java.lang.String PERCENTAGE,
           java.lang.String ABSOLUTE_SHARE,
           java.lang.String CURRENCY,
           java.lang.String CONDITION_PURPOSE1,
           java.math.BigDecimal UNIT_PRICE1) {
           this.FILENAME = FILENAME;
           this.REFERENCE_ID = REFERENCE_ID;
           this.ACTIVITY = ACTIVITY;
           this.COMP_CODE = COMP_CODE;
           this.CONTRACT_NO = CONTRACT_NO;
           this.COMPANY_CODE_MAIN = COMPANY_CODE_MAIN;
           this.MAIN_CONTRACT_NO = MAIN_CONTRACT_NO;
           this.OLD_CONTRACT_NO = OLD_CONTRACT_NO;
           this.CONTRACT_TYPE = CONTRACT_TYPE;
           this.OBJECT_DESC = OBJECT_DESC;
           this.CONTRACT_NAME = CONTRACT_NAME;
           this.CONTRACT_CONCLUSION_DATE = CONTRACT_CONCLUSION_DATE;
           this.DATE_CONTRACT_START = DATE_CONTRACT_START;
           this.DATE_FIRST_CONTRACT_END = DATE_FIRST_CONTRACT_END;
           this.AUTHORIZATION_GROUP = AUTHORIZATION_GROUP;
           this.INDUSTRY = INDUSTRY;
           this.PERSON_RESPONSIBLE = PERSON_RESPONSIBLE;
           this.CASH_FLOW_STARTING_ON = CASH_FLOW_STARTING_ON;
           this.FIRST_POSTING_FROM = FIRST_POSTING_FROM;
           this.CURRENCY_FOR_CONTRACT = CURRENCY_FOR_CONTRACT;
           this.TYPE_OF_RENEWAL = TYPE_OF_RENEWAL;
           this.RENEWAL_RULE = RENEWAL_RULE;
           this.SEQUENCE_NO = SEQUENCE_NO;
           this.NO_OF_RENEWALS = NO_OF_RENEWALS;
           this.CONTRACT_RENEWED_YEARS = CONTRACT_RENEWED_YEARS;
           this.CONTRACT_RENEWED_MONTHS = CONTRACT_RENEWED_MONTHS;
           this.CONTRACT_RENEWED_DAYS = CONTRACT_RENEWED_DAYS;
           this.TYPE_OF_AUTOMATIC_RENEWAL = TYPE_OF_AUTOMATIC_RENEWAL;
           this.RENEWAL_EXECUTION = RENEWAL_EXECUTION;
           this.TERM_NO = TERM_NO;
           this.PAYMENT_METHOD = PAYMENT_METHOD;
           this.PMT_METHSUPL = PMT_METHSUPL;
           this.INDIVID_SET = INDIVID_SET;
           this.PAYMENT_BLOCK_KEY = PAYMENT_BLOCK_KEY;
           this.TERMS_OF_PAYMENT_KEY = TERMS_OF_PAYMENT_KEY;
           this.KEY_FOR_HOUSE_BANK = KEY_FOR_HOUSE_BANK;
           this.BANK_DETAILS_ID = BANK_DETAILS_ID;
           this.NOTE_TO_PAYEE = NOTE_TO_PAYEE;
           this.DUNNING_AREA = DUNNING_AREA;
           this.DUNNING_BLOCK = DUNNING_BLOCK;
           this.ACCOUNT_DETERMINATION = ACCOUNT_DETERMINATION;
           this.TAX_TYPE = TAX_TYPE;
           this.TAX_GROUP = TAX_GROUP;
           this.BUSINESS_PARTNER_NO = BUSINESS_PARTNER_NO;
           this.TERM_NO1 = TERM_NO1;
           this.FREQUENCY = FREQUENCY;
           this.FREQUENCY_UNIT = FREQUENCY_UNIT;
           this.STARTING_MONTH = STARTING_MONTH;
           this.PAYMENT_FORM = PAYMENT_FORM;
           this.PRORATED = PRORATED;
           this.CALCULATE_METHOD = CALCULATE_METHOD;
           this.FACTORY_CALENDAR = FACTORY_CALENDAR;
           this.PARTNER_DAT = PARTNER_DAT;
           this.ROLE_TYPE = ROLE_TYPE;
           this.DATE_START_RELATIONSHIP = DATE_START_RELATIONSHIP;
           this.DATE_END_RELATIONSHIP = DATE_END_RELATIONSHIP;
           this.ADDRESS_TYPE = ADDRESS_TYPE;
           this.CONDITION_SPLIT = CONDITION_SPLIT;
           this.CONDITION_TYPE = CONDITION_TYPE;
           this.CONDITION_PURPOSE = CONDITION_PURPOSE;
           this.DATE_FROM_CONDITION = DATE_FROM_CONDITION;
           this.DATE_UP_TO_CONDITION = DATE_UP_TO_CONDITION;
           this.CURRENCY_CONDITION = CURRENCY_CONDITION;
           this.NO_POSTING_TERM = NO_POSTING_TERM;
           this.NO_FREQUENCY_TERM = NO_FREQUENCY_TERM;
           this.NO_ORGANIZATIONAL_TERM = NO_ORGANIZATIONAL_TERM;
           this.COST_CENTER = COST_CENTER;
           this.PROFIT_CENTER = PROFIT_CENTER;
           this.CALCULATION_FORMULA = CALCULATION_FORMULA;
           this.CURRENCY_UNIT_PRICE = CURRENCY_UNIT_PRICE;
           this.DISTRIBUTION_FORMULA = DISTRIBUTION_FORMULA;
           this.CONDITIONS_EXTERNAL_PURPOSE = CONDITIONS_EXTERNAL_PURPOSE;
           this.CONDITION_ONE_TIME1 = CONDITION_ONE_TIME1;
           this.STATISTICAL_INFO_CONDITION1 = STATISTICAL_INFO_CONDITION1;
           this.POSTING_START_DATE_CONDITION = POSTING_START_DATE_CONDITION;
           this.NO_OF_WHT_TERM = NO_OF_WHT_TERM;
           this.DIFFERENT_DUE_DATE_ONE_TIME = DIFFERENT_DUE_DATE_ONE_TIME;
           this.GRADING_TERM_IN_MONTHS = GRADING_TERM_IN_MONTHS;
           this.GRADING_INTERVAL_MONTHS = GRADING_INTERVAL_MONTHS;
           this.GRADING_PERCENT_INCREASE = GRADING_PERCENT_INCREASE;
           this.GRADING_ABSOLUTE_INCREASE = GRADING_ABSOLUTE_INCREASE;
           this.CONTRACT_STATUS = CONTRACT_STATUS;
           this.VALUATION_RULE = VALUATION_RULE;
           this.OBJECT_ID = OBJECT_ID;
           this.OBJECT_TYPE = OBJECT_TYPE;
           this.OBJECT_VALID_FROM = OBJECT_VALID_FROM;
           this.OBJECT_VALID_TO = OBJECT_VALID_TO;
           this.START_DATE_OF_CONSIDERATION = START_DATE_OF_CONSIDERATION;
           this.FIRST_POSTING_FROM1 = FIRST_POSTING_FROM1;
           this.CLASSIFICATION = CLASSIFICATION;
           this.INTEREST_RATE = INTEREST_RATE;
           this.FREQUENCY_TERM = FREQUENCY_TERM;
           this.DISTRIBUT_FORMULA = DISTRIBUT_FORMULA;
           this.DISTRIB_FORMULA_PARAMETER = DISTRIB_FORMULA_PARAMETER;
           this.PROBABLE_END = PROBABLE_END;
           this.END_OF_USAGE_ROU = END_OF_USAGE_ROU;
           this.VALUATION_STATUS = VALUATION_STATUS;
           this.VALUATION_BEHAVIOR = VALUATION_BEHAVIOR;
           this.COMPANY_CODE = COMPANY_CODE;
           this.ASSET = ASSET;
           this.SUBNO = SUBNO;
           this.OBJECT_DESCRIPTION = OBJECT_DESCRIPTION;
           this.ACCTASGOBJTYPE = ACCTASGOBJTYPE;
           this.ABSOLUTE_START = ABSOLUTE_START;
           this.ABSOLUTE_END = ABSOLUTE_END;
           this.COND_VAL_PROPERTY = COND_VAL_PROPERTY;
           this.COND_CONSIDERATION = COND_CONSIDERATION;
           this.CONSIDER_CONDITION = CONSIDER_CONDITION;
           this.PERCENTAGE = PERCENTAGE;
           this.ABSOLUTE_SHARE = ABSOLUTE_SHARE;
           this.CURRENCY = CURRENCY;
           this.CONDITION_PURPOSE1 = CONDITION_PURPOSE1;
           this.UNIT_PRICE1 = UNIT_PRICE1;
    }


    /**
     * Gets the FILENAME value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return FILENAME   * Local file for upload/download
     */
    public java.lang.String getFILENAME() {
        return FILENAME;
    }


    /**
     * Sets the FILENAME value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param FILENAME   * Local file for upload/download
     */
    public void setFILENAME(java.lang.String FILENAME) {
        this.FILENAME = FILENAME;
    }


    /**
     * Gets the REFERENCE_ID value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return REFERENCE_ID   * Refference ID
     */
    public java.lang.String getREFERENCE_ID() {
        return REFERENCE_ID;
    }


    /**
     * Sets the REFERENCE_ID value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param REFERENCE_ID   * Refference ID
     */
    public void setREFERENCE_ID(java.lang.String REFERENCE_ID) {
        this.REFERENCE_ID = REFERENCE_ID;
    }


    /**
     * Gets the ACTIVITY value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return ACTIVITY   * Single-Character Indicator
     */
    public java.lang.String getACTIVITY() {
        return ACTIVITY;
    }


    /**
     * Sets the ACTIVITY value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param ACTIVITY   * Single-Character Indicator
     */
    public void setACTIVITY(java.lang.String ACTIVITY) {
        this.ACTIVITY = ACTIVITY;
    }


    /**
     * Gets the COMP_CODE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return COMP_CODE   * Company Code
     */
    public java.lang.String getCOMP_CODE() {
        return COMP_CODE;
    }


    /**
     * Sets the COMP_CODE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param COMP_CODE   * Company Code
     */
    public void setCOMP_CODE(java.lang.String COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }


    /**
     * Gets the CONTRACT_NO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONTRACT_NO   * Contract Number
     */
    public java.lang.String getCONTRACT_NO() {
        return CONTRACT_NO;
    }


    /**
     * Sets the CONTRACT_NO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONTRACT_NO   * Contract Number
     */
    public void setCONTRACT_NO(java.lang.String CONTRACT_NO) {
        this.CONTRACT_NO = CONTRACT_NO;
    }


    /**
     * Gets the COMPANY_CODE_MAIN value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return COMPANY_CODE_MAIN   * Company code of main contract
     */
    public java.lang.String getCOMPANY_CODE_MAIN() {
        return COMPANY_CODE_MAIN;
    }


    /**
     * Sets the COMPANY_CODE_MAIN value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param COMPANY_CODE_MAIN   * Company code of main contract
     */
    public void setCOMPANY_CODE_MAIN(java.lang.String COMPANY_CODE_MAIN) {
        this.COMPANY_CODE_MAIN = COMPANY_CODE_MAIN;
    }


    /**
     * Gets the MAIN_CONTRACT_NO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return MAIN_CONTRACT_NO   * Number of old contract
     */
    public java.lang.String getMAIN_CONTRACT_NO() {
        return MAIN_CONTRACT_NO;
    }


    /**
     * Sets the MAIN_CONTRACT_NO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param MAIN_CONTRACT_NO   * Number of old contract
     */
    public void setMAIN_CONTRACT_NO(java.lang.String MAIN_CONTRACT_NO) {
        this.MAIN_CONTRACT_NO = MAIN_CONTRACT_NO;
    }


    /**
     * Gets the OLD_CONTRACT_NO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return OLD_CONTRACT_NO   * Number of old contract
     */
    public java.lang.String getOLD_CONTRACT_NO() {
        return OLD_CONTRACT_NO;
    }


    /**
     * Sets the OLD_CONTRACT_NO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param OLD_CONTRACT_NO   * Number of old contract
     */
    public void setOLD_CONTRACT_NO(java.lang.String OLD_CONTRACT_NO) {
        this.OLD_CONTRACT_NO = OLD_CONTRACT_NO;
    }


    /**
     * Gets the CONTRACT_TYPE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONTRACT_TYPE   * Contract Type
     */
    public java.lang.String getCONTRACT_TYPE() {
        return CONTRACT_TYPE;
    }


    /**
     * Sets the CONTRACT_TYPE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONTRACT_TYPE   * Contract Type
     */
    public void setCONTRACT_TYPE(java.lang.String CONTRACT_TYPE) {
        this.CONTRACT_TYPE = CONTRACT_TYPE;
    }


    /**
     * Gets the OBJECT_DESC value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return OBJECT_DESC   * Object Description
     */
    public java.lang.String getOBJECT_DESC() {
        return OBJECT_DESC;
    }


    /**
     * Sets the OBJECT_DESC value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param OBJECT_DESC   * Object Description
     */
    public void setOBJECT_DESC(java.lang.String OBJECT_DESC) {
        this.OBJECT_DESC = OBJECT_DESC;
    }


    /**
     * Gets the CONTRACT_NAME value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONTRACT_NAME   * Contract name
     */
    public java.lang.String getCONTRACT_NAME() {
        return CONTRACT_NAME;
    }


    /**
     * Sets the CONTRACT_NAME value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONTRACT_NAME   * Contract name
     */
    public void setCONTRACT_NAME(java.lang.String CONTRACT_NAME) {
        this.CONTRACT_NAME = CONTRACT_NAME;
    }


    /**
     * Gets the CONTRACT_CONCLUSION_DATE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONTRACT_CONCLUSION_DATE   * Contract conclusion Date
     */
    public java.lang.String getCONTRACT_CONCLUSION_DATE() {
        return CONTRACT_CONCLUSION_DATE;
    }


    /**
     * Sets the CONTRACT_CONCLUSION_DATE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONTRACT_CONCLUSION_DATE   * Contract conclusion Date
     */
    public void setCONTRACT_CONCLUSION_DATE(java.lang.String CONTRACT_CONCLUSION_DATE) {
        this.CONTRACT_CONCLUSION_DATE = CONTRACT_CONCLUSION_DATE;
    }


    /**
     * Gets the DATE_CONTRACT_START value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return DATE_CONTRACT_START   * Contract Start date
     */
    public java.lang.String getDATE_CONTRACT_START() {
        return DATE_CONTRACT_START;
    }


    /**
     * Sets the DATE_CONTRACT_START value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param DATE_CONTRACT_START   * Contract Start date
     */
    public void setDATE_CONTRACT_START(java.lang.String DATE_CONTRACT_START) {
        this.DATE_CONTRACT_START = DATE_CONTRACT_START;
    }


    /**
     * Gets the DATE_FIRST_CONTRACT_END value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return DATE_FIRST_CONTRACT_END   * Contract End Date
     */
    public java.lang.String getDATE_FIRST_CONTRACT_END() {
        return DATE_FIRST_CONTRACT_END;
    }


    /**
     * Sets the DATE_FIRST_CONTRACT_END value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param DATE_FIRST_CONTRACT_END   * Contract End Date
     */
    public void setDATE_FIRST_CONTRACT_END(java.lang.String DATE_FIRST_CONTRACT_END) {
        this.DATE_FIRST_CONTRACT_END = DATE_FIRST_CONTRACT_END;
    }


    /**
     * Gets the AUTHORIZATION_GROUP value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return AUTHORIZATION_GROUP   * Authorization Group
     */
    public java.lang.String getAUTHORIZATION_GROUP() {
        return AUTHORIZATION_GROUP;
    }


    /**
     * Sets the AUTHORIZATION_GROUP value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param AUTHORIZATION_GROUP   * Authorization Group
     */
    public void setAUTHORIZATION_GROUP(java.lang.String AUTHORIZATION_GROUP) {
        this.AUTHORIZATION_GROUP = AUTHORIZATION_GROUP;
    }


    /**
     * Gets the INDUSTRY value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return INDUSTRY   * Industry
     */
    public java.lang.String getINDUSTRY() {
        return INDUSTRY;
    }


    /**
     * Sets the INDUSTRY value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param INDUSTRY   * Industry
     */
    public void setINDUSTRY(java.lang.String INDUSTRY) {
        this.INDUSTRY = INDUSTRY;
    }


    /**
     * Gets the PERSON_RESPONSIBLE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return PERSON_RESPONSIBLE   * Person Responsible
     */
    public java.lang.String getPERSON_RESPONSIBLE() {
        return PERSON_RESPONSIBLE;
    }


    /**
     * Sets the PERSON_RESPONSIBLE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param PERSON_RESPONSIBLE   * Person Responsible
     */
    public void setPERSON_RESPONSIBLE(java.lang.String PERSON_RESPONSIBLE) {
        this.PERSON_RESPONSIBLE = PERSON_RESPONSIBLE;
    }


    /**
     * Gets the CASH_FLOW_STARTING_ON value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CASH_FLOW_STARTING_ON   * Cash Flow Generated Starting On
     */
    public java.lang.String getCASH_FLOW_STARTING_ON() {
        return CASH_FLOW_STARTING_ON;
    }


    /**
     * Sets the CASH_FLOW_STARTING_ON value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CASH_FLOW_STARTING_ON   * Cash Flow Generated Starting On
     */
    public void setCASH_FLOW_STARTING_ON(java.lang.String CASH_FLOW_STARTING_ON) {
        this.CASH_FLOW_STARTING_ON = CASH_FLOW_STARTING_ON;
    }


    /**
     * Gets the FIRST_POSTING_FROM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return FIRST_POSTING_FROM   * First Posting From
     */
    public java.lang.String getFIRST_POSTING_FROM() {
        return FIRST_POSTING_FROM;
    }


    /**
     * Sets the FIRST_POSTING_FROM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param FIRST_POSTING_FROM   * First Posting From
     */
    public void setFIRST_POSTING_FROM(java.lang.String FIRST_POSTING_FROM) {
        this.FIRST_POSTING_FROM = FIRST_POSTING_FROM;
    }


    /**
     * Gets the CURRENCY_FOR_CONTRACT value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CURRENCY_FOR_CONTRACT   * Currency for Contract
     */
    public java.lang.String getCURRENCY_FOR_CONTRACT() {
        return CURRENCY_FOR_CONTRACT;
    }


    /**
     * Sets the CURRENCY_FOR_CONTRACT value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CURRENCY_FOR_CONTRACT   * Currency for Contract
     */
    public void setCURRENCY_FOR_CONTRACT(java.lang.String CURRENCY_FOR_CONTRACT) {
        this.CURRENCY_FOR_CONTRACT = CURRENCY_FOR_CONTRACT;
    }


    /**
     * Gets the TYPE_OF_RENEWAL value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return TYPE_OF_RENEWAL   * Type of Renewal of Real Estate Contract
     */
    public java.lang.String getTYPE_OF_RENEWAL() {
        return TYPE_OF_RENEWAL;
    }


    /**
     * Sets the TYPE_OF_RENEWAL value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param TYPE_OF_RENEWAL   * Type of Renewal of Real Estate Contract
     */
    public void setTYPE_OF_RENEWAL(java.lang.String TYPE_OF_RENEWAL) {
        this.TYPE_OF_RENEWAL = TYPE_OF_RENEWAL;
    }


    /**
     * Gets the RENEWAL_RULE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return RENEWAL_RULE   * Renewal Rule
     */
    public java.lang.String getRENEWAL_RULE() {
        return RENEWAL_RULE;
    }


    /**
     * Sets the RENEWAL_RULE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param RENEWAL_RULE   * Renewal Rule
     */
    public void setRENEWAL_RULE(java.lang.String RENEWAL_RULE) {
        this.RENEWAL_RULE = RENEWAL_RULE;
    }


    /**
     * Gets the SEQUENCE_NO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return SEQUENCE_NO   * sequence no
     */
    public java.lang.String getSEQUENCE_NO() {
        return SEQUENCE_NO;
    }


    /**
     * Sets the SEQUENCE_NO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param SEQUENCE_NO   * sequence no
     */
    public void setSEQUENCE_NO(java.lang.String SEQUENCE_NO) {
        this.SEQUENCE_NO = SEQUENCE_NO;
    }


    /**
     * Gets the NO_OF_RENEWALS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return NO_OF_RENEWALS   * Number of Renewals
     */
    public java.lang.String getNO_OF_RENEWALS() {
        return NO_OF_RENEWALS;
    }


    /**
     * Sets the NO_OF_RENEWALS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param NO_OF_RENEWALS   * Number of Renewals
     */
    public void setNO_OF_RENEWALS(java.lang.String NO_OF_RENEWALS) {
        this.NO_OF_RENEWALS = NO_OF_RENEWALS;
    }


    /**
     * Gets the CONTRACT_RENEWED_YEARS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONTRACT_RENEWED_YEARS   * Contract Renewed for Number of Years
     */
    public java.lang.String getCONTRACT_RENEWED_YEARS() {
        return CONTRACT_RENEWED_YEARS;
    }


    /**
     * Sets the CONTRACT_RENEWED_YEARS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONTRACT_RENEWED_YEARS   * Contract Renewed for Number of Years
     */
    public void setCONTRACT_RENEWED_YEARS(java.lang.String CONTRACT_RENEWED_YEARS) {
        this.CONTRACT_RENEWED_YEARS = CONTRACT_RENEWED_YEARS;
    }


    /**
     * Gets the CONTRACT_RENEWED_MONTHS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONTRACT_RENEWED_MONTHS   * Contract Renewed for Number of Months
     */
    public java.lang.String getCONTRACT_RENEWED_MONTHS() {
        return CONTRACT_RENEWED_MONTHS;
    }


    /**
     * Sets the CONTRACT_RENEWED_MONTHS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONTRACT_RENEWED_MONTHS   * Contract Renewed for Number of Months
     */
    public void setCONTRACT_RENEWED_MONTHS(java.lang.String CONTRACT_RENEWED_MONTHS) {
        this.CONTRACT_RENEWED_MONTHS = CONTRACT_RENEWED_MONTHS;
    }


    /**
     * Gets the CONTRACT_RENEWED_DAYS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONTRACT_RENEWED_DAYS   * Contract Renewed for Number of Days
     */
    public java.lang.String getCONTRACT_RENEWED_DAYS() {
        return CONTRACT_RENEWED_DAYS;
    }


    /**
     * Sets the CONTRACT_RENEWED_DAYS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONTRACT_RENEWED_DAYS   * Contract Renewed for Number of Days
     */
    public void setCONTRACT_RENEWED_DAYS(java.lang.String CONTRACT_RENEWED_DAYS) {
        this.CONTRACT_RENEWED_DAYS = CONTRACT_RENEWED_DAYS;
    }


    /**
     * Gets the TYPE_OF_AUTOMATIC_RENEWAL value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return TYPE_OF_AUTOMATIC_RENEWAL   * Type of Automatic Renewal
     */
    public java.lang.String getTYPE_OF_AUTOMATIC_RENEWAL() {
        return TYPE_OF_AUTOMATIC_RENEWAL;
    }


    /**
     * Sets the TYPE_OF_AUTOMATIC_RENEWAL value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param TYPE_OF_AUTOMATIC_RENEWAL   * Type of Automatic Renewal
     */
    public void setTYPE_OF_AUTOMATIC_RENEWAL(java.lang.String TYPE_OF_AUTOMATIC_RENEWAL) {
        this.TYPE_OF_AUTOMATIC_RENEWAL = TYPE_OF_AUTOMATIC_RENEWAL;
    }


    /**
     * Gets the RENEWAL_EXECUTION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return RENEWAL_EXECUTION   * Renewal Execution
     */
    public java.lang.String getRENEWAL_EXECUTION() {
        return RENEWAL_EXECUTION;
    }


    /**
     * Sets the RENEWAL_EXECUTION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param RENEWAL_EXECUTION   * Renewal Execution
     */
    public void setRENEWAL_EXECUTION(java.lang.String RENEWAL_EXECUTION) {
        this.RENEWAL_EXECUTION = RENEWAL_EXECUTION;
    }


    /**
     * Gets the TERM_NO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return TERM_NO   * Term Number
     */
    public java.lang.String getTERM_NO() {
        return TERM_NO;
    }


    /**
     * Sets the TERM_NO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param TERM_NO   * Term Number
     */
    public void setTERM_NO(java.lang.String TERM_NO) {
        this.TERM_NO = TERM_NO;
    }


    /**
     * Gets the PAYMENT_METHOD value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return PAYMENT_METHOD   * Payment Method
     */
    public java.lang.String getPAYMENT_METHOD() {
        return PAYMENT_METHOD;
    }


    /**
     * Sets the PAYMENT_METHOD value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param PAYMENT_METHOD   * Payment Method
     */
    public void setPAYMENT_METHOD(java.lang.String PAYMENT_METHOD) {
        this.PAYMENT_METHOD = PAYMENT_METHOD;
    }


    /**
     * Gets the PMT_METHSUPL value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return PMT_METHSUPL   * Pmt meth.supl.
     */
    public java.lang.String getPMT_METHSUPL() {
        return PMT_METHSUPL;
    }


    /**
     * Sets the PMT_METHSUPL value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param PMT_METHSUPL   * Pmt meth.supl.
     */
    public void setPMT_METHSUPL(java.lang.String PMT_METHSUPL) {
        this.PMT_METHSUPL = PMT_METHSUPL;
    }


    /**
     * Gets the INDIVID_SET value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return INDIVID_SET   * Individ. Set
     */
    public java.lang.String getINDIVID_SET() {
        return INDIVID_SET;
    }


    /**
     * Sets the INDIVID_SET value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param INDIVID_SET   * Individ. Set
     */
    public void setINDIVID_SET(java.lang.String INDIVID_SET) {
        this.INDIVID_SET = INDIVID_SET;
    }


    /**
     * Gets the PAYMENT_BLOCK_KEY value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return PAYMENT_BLOCK_KEY   * Payment block key
     */
    public java.lang.String getPAYMENT_BLOCK_KEY() {
        return PAYMENT_BLOCK_KEY;
    }


    /**
     * Sets the PAYMENT_BLOCK_KEY value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param PAYMENT_BLOCK_KEY   * Payment block key
     */
    public void setPAYMENT_BLOCK_KEY(java.lang.String PAYMENT_BLOCK_KEY) {
        this.PAYMENT_BLOCK_KEY = PAYMENT_BLOCK_KEY;
    }


    /**
     * Gets the TERMS_OF_PAYMENT_KEY value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return TERMS_OF_PAYMENT_KEY   * Terms of Payment Key
     */
    public java.lang.String getTERMS_OF_PAYMENT_KEY() {
        return TERMS_OF_PAYMENT_KEY;
    }


    /**
     * Sets the TERMS_OF_PAYMENT_KEY value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param TERMS_OF_PAYMENT_KEY   * Terms of Payment Key
     */
    public void setTERMS_OF_PAYMENT_KEY(java.lang.String TERMS_OF_PAYMENT_KEY) {
        this.TERMS_OF_PAYMENT_KEY = TERMS_OF_PAYMENT_KEY;
    }


    /**
     * Gets the KEY_FOR_HOUSE_BANK value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return KEY_FOR_HOUSE_BANK   * Key for House Bank
     */
    public java.lang.String getKEY_FOR_HOUSE_BANK() {
        return KEY_FOR_HOUSE_BANK;
    }


    /**
     * Sets the KEY_FOR_HOUSE_BANK value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param KEY_FOR_HOUSE_BANK   * Key for House Bank
     */
    public void setKEY_FOR_HOUSE_BANK(java.lang.String KEY_FOR_HOUSE_BANK) {
        this.KEY_FOR_HOUSE_BANK = KEY_FOR_HOUSE_BANK;
    }


    /**
     * Gets the BANK_DETAILS_ID value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return BANK_DETAILS_ID   * Bank Details ID
     */
    public java.lang.String getBANK_DETAILS_ID() {
        return BANK_DETAILS_ID;
    }


    /**
     * Sets the BANK_DETAILS_ID value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param BANK_DETAILS_ID   * Bank Details ID
     */
    public void setBANK_DETAILS_ID(java.lang.String BANK_DETAILS_ID) {
        this.BANK_DETAILS_ID = BANK_DETAILS_ID;
    }


    /**
     * Gets the NOTE_TO_PAYEE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return NOTE_TO_PAYEE   * Note to Payee
     */
    public java.lang.String getNOTE_TO_PAYEE() {
        return NOTE_TO_PAYEE;
    }


    /**
     * Sets the NOTE_TO_PAYEE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param NOTE_TO_PAYEE   * Note to Payee
     */
    public void setNOTE_TO_PAYEE(java.lang.String NOTE_TO_PAYEE) {
        this.NOTE_TO_PAYEE = NOTE_TO_PAYEE;
    }


    /**
     * Gets the DUNNING_AREA value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return DUNNING_AREA   * Dunning Area
     */
    public java.lang.String getDUNNING_AREA() {
        return DUNNING_AREA;
    }


    /**
     * Sets the DUNNING_AREA value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param DUNNING_AREA   * Dunning Area
     */
    public void setDUNNING_AREA(java.lang.String DUNNING_AREA) {
        this.DUNNING_AREA = DUNNING_AREA;
    }


    /**
     * Gets the DUNNING_BLOCK value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return DUNNING_BLOCK   * Dunning Block
     */
    public java.lang.String getDUNNING_BLOCK() {
        return DUNNING_BLOCK;
    }


    /**
     * Sets the DUNNING_BLOCK value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param DUNNING_BLOCK   * Dunning Block
     */
    public void setDUNNING_BLOCK(java.lang.String DUNNING_BLOCK) {
        this.DUNNING_BLOCK = DUNNING_BLOCK;
    }


    /**
     * Gets the ACCOUNT_DETERMINATION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return ACCOUNT_DETERMINATION   * Account Determination Value
     */
    public java.lang.String getACCOUNT_DETERMINATION() {
        return ACCOUNT_DETERMINATION;
    }


    /**
     * Sets the ACCOUNT_DETERMINATION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param ACCOUNT_DETERMINATION   * Account Determination Value
     */
    public void setACCOUNT_DETERMINATION(java.lang.String ACCOUNT_DETERMINATION) {
        this.ACCOUNT_DETERMINATION = ACCOUNT_DETERMINATION;
    }


    /**
     * Gets the TAX_TYPE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return TAX_TYPE   * Tax Type
     */
    public java.lang.String getTAX_TYPE() {
        return TAX_TYPE;
    }


    /**
     * Sets the TAX_TYPE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param TAX_TYPE   * Tax Type
     */
    public void setTAX_TYPE(java.lang.String TAX_TYPE) {
        this.TAX_TYPE = TAX_TYPE;
    }


    /**
     * Gets the TAX_GROUP value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return TAX_GROUP   * Tax Group
     */
    public java.lang.String getTAX_GROUP() {
        return TAX_GROUP;
    }


    /**
     * Sets the TAX_GROUP value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param TAX_GROUP   * Tax Group
     */
    public void setTAX_GROUP(java.lang.String TAX_GROUP) {
        this.TAX_GROUP = TAX_GROUP;
    }


    /**
     * Gets the BUSINESS_PARTNER_NO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return BUSINESS_PARTNER_NO   * Business Partner Number
     */
    public java.lang.String getBUSINESS_PARTNER_NO() {
        return BUSINESS_PARTNER_NO;
    }


    /**
     * Sets the BUSINESS_PARTNER_NO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param BUSINESS_PARTNER_NO   * Business Partner Number
     */
    public void setBUSINESS_PARTNER_NO(java.lang.String BUSINESS_PARTNER_NO) {
        this.BUSINESS_PARTNER_NO = BUSINESS_PARTNER_NO;
    }


    /**
     * Gets the TERM_NO1 value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return TERM_NO1   * Term Number
     */
    public java.lang.String getTERM_NO1() {
        return TERM_NO1;
    }


    /**
     * Sets the TERM_NO1 value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param TERM_NO1   * Term Number
     */
    public void setTERM_NO1(java.lang.String TERM_NO1) {
        this.TERM_NO1 = TERM_NO1;
    }


    /**
     * Gets the FREQUENCY value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return FREQUENCY   * Number of Frequency Units of Period
     */
    public java.lang.String getFREQUENCY() {
        return FREQUENCY;
    }


    /**
     * Sets the FREQUENCY value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param FREQUENCY   * Number of Frequency Units of Period
     */
    public void setFREQUENCY(java.lang.String FREQUENCY) {
        this.FREQUENCY = FREQUENCY;
    }


    /**
     * Gets the FREQUENCY_UNIT value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return FREQUENCY_UNIT   * Frequency Unit
     */
    public java.lang.String getFREQUENCY_UNIT() {
        return FREQUENCY_UNIT;
    }


    /**
     * Sets the FREQUENCY_UNIT value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param FREQUENCY_UNIT   * Frequency Unit
     */
    public void setFREQUENCY_UNIT(java.lang.String FREQUENCY_UNIT) {
        this.FREQUENCY_UNIT = FREQUENCY_UNIT;
    }


    /**
     * Gets the STARTING_MONTH value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return STARTING_MONTH   * Start of Frequency for Daily, Monthly, and Yearly Frequency
     */
    public java.lang.String getSTARTING_MONTH() {
        return STARTING_MONTH;
    }


    /**
     * Sets the STARTING_MONTH value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param STARTING_MONTH   * Start of Frequency for Daily, Monthly, and Yearly Frequency
     */
    public void setSTARTING_MONTH(java.lang.String STARTING_MONTH) {
        this.STARTING_MONTH = STARTING_MONTH;
    }


    /**
     * Gets the PAYMENT_FORM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return PAYMENT_FORM   * Payment Form (Period Start, Mid-Period, In Arrears, Example)
     */
    public java.lang.String getPAYMENT_FORM() {
        return PAYMENT_FORM;
    }


    /**
     * Sets the PAYMENT_FORM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param PAYMENT_FORM   * Payment Form (Period Start, Mid-Period, In Arrears, Example)
     */
    public void setPAYMENT_FORM(java.lang.String PAYMENT_FORM) {
        this.PAYMENT_FORM = PAYMENT_FORM;
    }


    /**
     * Gets the PRORATED value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return PRORATED   * Pro Rata Method
     */
    public java.lang.String getPRORATED() {
        return PRORATED;
    }


    /**
     * Sets the PRORATED value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param PRORATED   * Pro Rata Method
     */
    public void setPRORATED(java.lang.String PRORATED) {
        this.PRORATED = PRORATED;
    }


    /**
     * Gets the CALCULATE_METHOD value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CALCULATE_METHOD   * Calculation method for time-dependent periods
     */
    public java.lang.String getCALCULATE_METHOD() {
        return CALCULATE_METHOD;
    }


    /**
     * Sets the CALCULATE_METHOD value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CALCULATE_METHOD   * Calculation method for time-dependent periods
     */
    public void setCALCULATE_METHOD(java.lang.String CALCULATE_METHOD) {
        this.CALCULATE_METHOD = CALCULATE_METHOD;
    }


    /**
     * Gets the FACTORY_CALENDAR value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return FACTORY_CALENDAR   * Factory Calendar
     */
    public java.lang.String getFACTORY_CALENDAR() {
        return FACTORY_CALENDAR;
    }


    /**
     * Sets the FACTORY_CALENDAR value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param FACTORY_CALENDAR   * Factory Calendar
     */
    public void setFACTORY_CALENDAR(java.lang.String FACTORY_CALENDAR) {
        this.FACTORY_CALENDAR = FACTORY_CALENDAR;
    }


    /**
     * Gets the PARTNER_DAT value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return PARTNER_DAT   * Business Partner Number
     */
    public java.lang.String getPARTNER_DAT() {
        return PARTNER_DAT;
    }


    /**
     * Sets the PARTNER_DAT value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param PARTNER_DAT   * Business Partner Number
     */
    public void setPARTNER_DAT(java.lang.String PARTNER_DAT) {
        this.PARTNER_DAT = PARTNER_DAT;
    }


    /**
     * Gets the ROLE_TYPE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return ROLE_TYPE   * Business Partner: Role
     */
    public java.lang.String getROLE_TYPE() {
        return ROLE_TYPE;
    }


    /**
     * Sets the ROLE_TYPE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param ROLE_TYPE   * Business Partner: Role
     */
    public void setROLE_TYPE(java.lang.String ROLE_TYPE) {
        this.ROLE_TYPE = ROLE_TYPE;
    }


    /**
     * Gets the DATE_START_RELATIONSHIP value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return DATE_START_RELATIONSHIP   * Date of Start of Relationship
     */
    public java.lang.String getDATE_START_RELATIONSHIP() {
        return DATE_START_RELATIONSHIP;
    }


    /**
     * Sets the DATE_START_RELATIONSHIP value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param DATE_START_RELATIONSHIP   * Date of Start of Relationship
     */
    public void setDATE_START_RELATIONSHIP(java.lang.String DATE_START_RELATIONSHIP) {
        this.DATE_START_RELATIONSHIP = DATE_START_RELATIONSHIP;
    }


    /**
     * Gets the DATE_END_RELATIONSHIP value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return DATE_END_RELATIONSHIP   * Date of End of Relationship
     */
    public java.lang.String getDATE_END_RELATIONSHIP() {
        return DATE_END_RELATIONSHIP;
    }


    /**
     * Sets the DATE_END_RELATIONSHIP value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param DATE_END_RELATIONSHIP   * Date of End of Relationship
     */
    public void setDATE_END_RELATIONSHIP(java.lang.String DATE_END_RELATIONSHIP) {
        this.DATE_END_RELATIONSHIP = DATE_END_RELATIONSHIP;
    }


    /**
     * Gets the ADDRESS_TYPE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return ADDRESS_TYPE   * Address Type
     */
    public java.lang.String getADDRESS_TYPE() {
        return ADDRESS_TYPE;
    }


    /**
     * Sets the ADDRESS_TYPE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param ADDRESS_TYPE   * Address Type
     */
    public void setADDRESS_TYPE(java.lang.String ADDRESS_TYPE) {
        this.ADDRESS_TYPE = ADDRESS_TYPE;
    }


    /**
     * Gets the CONDITION_SPLIT value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONDITION_SPLIT   * Equivalence Number
     */
    public java.lang.String getCONDITION_SPLIT() {
        return CONDITION_SPLIT;
    }


    /**
     * Sets the CONDITION_SPLIT value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONDITION_SPLIT   * Equivalence Number
     */
    public void setCONDITION_SPLIT(java.lang.String CONDITION_SPLIT) {
        this.CONDITION_SPLIT = CONDITION_SPLIT;
    }


    /**
     * Gets the CONDITION_TYPE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONDITION_TYPE   * Condition Type
     */
    public java.lang.String getCONDITION_TYPE() {
        return CONDITION_TYPE;
    }


    /**
     * Sets the CONDITION_TYPE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONDITION_TYPE   * Condition Type
     */
    public void setCONDITION_TYPE(java.lang.String CONDITION_TYPE) {
        this.CONDITION_TYPE = CONDITION_TYPE;
    }


    /**
     * Gets the CONDITION_PURPOSE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONDITION_PURPOSE   * Conditions - External Purpose
     */
    public java.lang.String getCONDITION_PURPOSE() {
        return CONDITION_PURPOSE;
    }


    /**
     * Sets the CONDITION_PURPOSE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONDITION_PURPOSE   * Conditions - External Purpose
     */
    public void setCONDITION_PURPOSE(java.lang.String CONDITION_PURPOSE) {
        this.CONDITION_PURPOSE = CONDITION_PURPOSE;
    }


    /**
     * Gets the DATE_FROM_CONDITION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return DATE_FROM_CONDITION   * Date from when condition is valid
     */
    public java.lang.String getDATE_FROM_CONDITION() {
        return DATE_FROM_CONDITION;
    }


    /**
     * Sets the DATE_FROM_CONDITION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param DATE_FROM_CONDITION   * Date from when condition is valid
     */
    public void setDATE_FROM_CONDITION(java.lang.String DATE_FROM_CONDITION) {
        this.DATE_FROM_CONDITION = DATE_FROM_CONDITION;
    }


    /**
     * Gets the DATE_UP_TO_CONDITION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return DATE_UP_TO_CONDITION   * Date up to when condition is valid
     */
    public java.lang.String getDATE_UP_TO_CONDITION() {
        return DATE_UP_TO_CONDITION;
    }


    /**
     * Sets the DATE_UP_TO_CONDITION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param DATE_UP_TO_CONDITION   * Date up to when condition is valid
     */
    public void setDATE_UP_TO_CONDITION(java.lang.String DATE_UP_TO_CONDITION) {
        this.DATE_UP_TO_CONDITION = DATE_UP_TO_CONDITION;
    }


    /**
     * Gets the CURRENCY_CONDITION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CURRENCY_CONDITION   * Currency of condition item
     */
    public java.lang.String getCURRENCY_CONDITION() {
        return CURRENCY_CONDITION;
    }


    /**
     * Sets the CURRENCY_CONDITION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CURRENCY_CONDITION   * Currency of condition item
     */
    public void setCURRENCY_CONDITION(java.lang.String CURRENCY_CONDITION) {
        this.CURRENCY_CONDITION = CURRENCY_CONDITION;
    }


    /**
     * Gets the NO_POSTING_TERM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return NO_POSTING_TERM   * Number of Posting Term
     */
    public java.lang.String getNO_POSTING_TERM() {
        return NO_POSTING_TERM;
    }


    /**
     * Sets the NO_POSTING_TERM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param NO_POSTING_TERM   * Number of Posting Term
     */
    public void setNO_POSTING_TERM(java.lang.String NO_POSTING_TERM) {
        this.NO_POSTING_TERM = NO_POSTING_TERM;
    }


    /**
     * Gets the NO_FREQUENCY_TERM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return NO_FREQUENCY_TERM   * Number of Frequency Term
     */
    public java.lang.String getNO_FREQUENCY_TERM() {
        return NO_FREQUENCY_TERM;
    }


    /**
     * Sets the NO_FREQUENCY_TERM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param NO_FREQUENCY_TERM   * Number of Frequency Term
     */
    public void setNO_FREQUENCY_TERM(java.lang.String NO_FREQUENCY_TERM) {
        this.NO_FREQUENCY_TERM = NO_FREQUENCY_TERM;
    }


    /**
     * Gets the NO_ORGANIZATIONAL_TERM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return NO_ORGANIZATIONAL_TERM   * Number of Organizational Assignment Term
     */
    public java.lang.String getNO_ORGANIZATIONAL_TERM() {
        return NO_ORGANIZATIONAL_TERM;
    }


    /**
     * Sets the NO_ORGANIZATIONAL_TERM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param NO_ORGANIZATIONAL_TERM   * Number of Organizational Assignment Term
     */
    public void setNO_ORGANIZATIONAL_TERM(java.lang.String NO_ORGANIZATIONAL_TERM) {
        this.NO_ORGANIZATIONAL_TERM = NO_ORGANIZATIONAL_TERM;
    }


    /**
     * Gets the COST_CENTER value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return COST_CENTER   * Complete Object Identification, for Example BE 1000/123
     */
    public java.lang.String getCOST_CENTER() {
        return COST_CENTER;
    }


    /**
     * Sets the COST_CENTER value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param COST_CENTER   * Complete Object Identification, for Example BE 1000/123
     */
    public void setCOST_CENTER(java.lang.String COST_CENTER) {
        this.COST_CENTER = COST_CENTER;
    }


    /**
     * Gets the PROFIT_CENTER value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return PROFIT_CENTER   * Profit Center
     */
    public java.lang.String getPROFIT_CENTER() {
        return PROFIT_CENTER;
    }


    /**
     * Sets the PROFIT_CENTER value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param PROFIT_CENTER   * Profit Center
     */
    public void setPROFIT_CENTER(java.lang.String PROFIT_CENTER) {
        this.PROFIT_CENTER = PROFIT_CENTER;
    }


    /**
     * Gets the CALCULATION_FORMULA value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CALCULATION_FORMULA   * Calculation Formula
     */
    public java.lang.String getCALCULATION_FORMULA() {
        return CALCULATION_FORMULA;
    }


    /**
     * Sets the CALCULATION_FORMULA value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CALCULATION_FORMULA   * Calculation Formula
     */
    public void setCALCULATION_FORMULA(java.lang.String CALCULATION_FORMULA) {
        this.CALCULATION_FORMULA = CALCULATION_FORMULA;
    }


    /**
     * Gets the CURRENCY_UNIT_PRICE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CURRENCY_UNIT_PRICE   * Unit Price
     */
    public java.math.BigDecimal getCURRENCY_UNIT_PRICE() {
        return CURRENCY_UNIT_PRICE;
    }


    /**
     * Sets the CURRENCY_UNIT_PRICE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CURRENCY_UNIT_PRICE   * Unit Price
     */
    public void setCURRENCY_UNIT_PRICE(java.math.BigDecimal CURRENCY_UNIT_PRICE) {
        this.CURRENCY_UNIT_PRICE = CURRENCY_UNIT_PRICE;
    }


    /**
     * Gets the DISTRIBUTION_FORMULA value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return DISTRIBUTION_FORMULA   * Distribution Formula
     */
    public java.lang.String getDISTRIBUTION_FORMULA() {
        return DISTRIBUTION_FORMULA;
    }


    /**
     * Sets the DISTRIBUTION_FORMULA value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param DISTRIBUTION_FORMULA   * Distribution Formula
     */
    public void setDISTRIBUTION_FORMULA(java.lang.String DISTRIBUTION_FORMULA) {
        this.DISTRIBUTION_FORMULA = DISTRIBUTION_FORMULA;
    }


    /**
     * Gets the CONDITIONS_EXTERNAL_PURPOSE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONDITIONS_EXTERNAL_PURPOSE   * Dummy
     */
    public java.lang.String getCONDITIONS_EXTERNAL_PURPOSE() {
        return CONDITIONS_EXTERNAL_PURPOSE;
    }


    /**
     * Sets the CONDITIONS_EXTERNAL_PURPOSE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONDITIONS_EXTERNAL_PURPOSE   * Dummy
     */
    public void setCONDITIONS_EXTERNAL_PURPOSE(java.lang.String CONDITIONS_EXTERNAL_PURPOSE) {
        this.CONDITIONS_EXTERNAL_PURPOSE = CONDITIONS_EXTERNAL_PURPOSE;
    }


    /**
     * Gets the CONDITION_ONE_TIME1 value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONDITION_ONE_TIME1   * Condition Is One-Time Condition
     */
    public java.lang.String getCONDITION_ONE_TIME1() {
        return CONDITION_ONE_TIME1;
    }


    /**
     * Sets the CONDITION_ONE_TIME1 value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONDITION_ONE_TIME1   * Condition Is One-Time Condition
     */
    public void setCONDITION_ONE_TIME1(java.lang.String CONDITION_ONE_TIME1) {
        this.CONDITION_ONE_TIME1 = CONDITION_ONE_TIME1;
    }


    /**
     * Gets the STATISTICAL_INFO_CONDITION1 value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return STATISTICAL_INFO_CONDITION1   * Statistical or Informational Condition
     */
    public java.lang.String getSTATISTICAL_INFO_CONDITION1() {
        return STATISTICAL_INFO_CONDITION1;
    }


    /**
     * Sets the STATISTICAL_INFO_CONDITION1 value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param STATISTICAL_INFO_CONDITION1   * Statistical or Informational Condition
     */
    public void setSTATISTICAL_INFO_CONDITION1(java.lang.String STATISTICAL_INFO_CONDITION1) {
        this.STATISTICAL_INFO_CONDITION1 = STATISTICAL_INFO_CONDITION1;
    }


    /**
     * Gets the POSTING_START_DATE_CONDITION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return POSTING_START_DATE_CONDITION   * First Posting From
     */
    public java.lang.String getPOSTING_START_DATE_CONDITION() {
        return POSTING_START_DATE_CONDITION;
    }


    /**
     * Sets the POSTING_START_DATE_CONDITION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param POSTING_START_DATE_CONDITION   * First Posting From
     */
    public void setPOSTING_START_DATE_CONDITION(java.lang.String POSTING_START_DATE_CONDITION) {
        this.POSTING_START_DATE_CONDITION = POSTING_START_DATE_CONDITION;
    }


    /**
     * Gets the NO_OF_WHT_TERM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return NO_OF_WHT_TERM   * Dummy
     */
    public java.lang.String getNO_OF_WHT_TERM() {
        return NO_OF_WHT_TERM;
    }


    /**
     * Sets the NO_OF_WHT_TERM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param NO_OF_WHT_TERM   * Dummy
     */
    public void setNO_OF_WHT_TERM(java.lang.String NO_OF_WHT_TERM) {
        this.NO_OF_WHT_TERM = NO_OF_WHT_TERM;
    }


    /**
     * Gets the DIFFERENT_DUE_DATE_ONE_TIME value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return DIFFERENT_DUE_DATE_ONE_TIME   * Different Due Date of One-Time Condition
     */
    public java.lang.String getDIFFERENT_DUE_DATE_ONE_TIME() {
        return DIFFERENT_DUE_DATE_ONE_TIME;
    }


    /**
     * Sets the DIFFERENT_DUE_DATE_ONE_TIME value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param DIFFERENT_DUE_DATE_ONE_TIME   * Different Due Date of One-Time Condition
     */
    public void setDIFFERENT_DUE_DATE_ONE_TIME(java.lang.String DIFFERENT_DUE_DATE_ONE_TIME) {
        this.DIFFERENT_DUE_DATE_ONE_TIME = DIFFERENT_DUE_DATE_ONE_TIME;
    }


    /**
     * Gets the GRADING_TERM_IN_MONTHS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return GRADING_TERM_IN_MONTHS   * Grading Term in Months
     */
    public java.math.BigInteger getGRADING_TERM_IN_MONTHS() {
        return GRADING_TERM_IN_MONTHS;
    }


    /**
     * Sets the GRADING_TERM_IN_MONTHS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param GRADING_TERM_IN_MONTHS   * Grading Term in Months
     */
    public void setGRADING_TERM_IN_MONTHS(java.math.BigInteger GRADING_TERM_IN_MONTHS) {
        this.GRADING_TERM_IN_MONTHS = GRADING_TERM_IN_MONTHS;
    }


    /**
     * Gets the GRADING_INTERVAL_MONTHS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return GRADING_INTERVAL_MONTHS   * Grading Interval in Months
     */
    public java.math.BigInteger getGRADING_INTERVAL_MONTHS() {
        return GRADING_INTERVAL_MONTHS;
    }


    /**
     * Sets the GRADING_INTERVAL_MONTHS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param GRADING_INTERVAL_MONTHS   * Grading Interval in Months
     */
    public void setGRADING_INTERVAL_MONTHS(java.math.BigInteger GRADING_INTERVAL_MONTHS) {
        this.GRADING_INTERVAL_MONTHS = GRADING_INTERVAL_MONTHS;
    }


    /**
     * Gets the GRADING_PERCENT_INCREASE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return GRADING_PERCENT_INCREASE   * Grading Percent Increase
     */
    public java.math.BigDecimal getGRADING_PERCENT_INCREASE() {
        return GRADING_PERCENT_INCREASE;
    }


    /**
     * Sets the GRADING_PERCENT_INCREASE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param GRADING_PERCENT_INCREASE   * Grading Percent Increase
     */
    public void setGRADING_PERCENT_INCREASE(java.math.BigDecimal GRADING_PERCENT_INCREASE) {
        this.GRADING_PERCENT_INCREASE = GRADING_PERCENT_INCREASE;
    }


    /**
     * Gets the GRADING_ABSOLUTE_INCREASE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return GRADING_ABSOLUTE_INCREASE   * Grading Absolute Increase
     */
    public java.math.BigInteger getGRADING_ABSOLUTE_INCREASE() {
        return GRADING_ABSOLUTE_INCREASE;
    }


    /**
     * Sets the GRADING_ABSOLUTE_INCREASE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param GRADING_ABSOLUTE_INCREASE   * Grading Absolute Increase
     */
    public void setGRADING_ABSOLUTE_INCREASE(java.math.BigInteger GRADING_ABSOLUTE_INCREASE) {
        this.GRADING_ABSOLUTE_INCREASE = GRADING_ABSOLUTE_INCREASE;
    }


    /**
     * Gets the CONTRACT_STATUS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONTRACT_STATUS   * Business Transaction
     */
    public java.lang.String getCONTRACT_STATUS() {
        return CONTRACT_STATUS;
    }


    /**
     * Sets the CONTRACT_STATUS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONTRACT_STATUS   * Business Transaction
     */
    public void setCONTRACT_STATUS(java.lang.String CONTRACT_STATUS) {
        this.CONTRACT_STATUS = CONTRACT_STATUS;
    }


    /**
     * Gets the VALUATION_RULE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return VALUATION_RULE   * Valuation Rule
     */
    public java.lang.String getVALUATION_RULE() {
        return VALUATION_RULE;
    }


    /**
     * Sets the VALUATION_RULE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param VALUATION_RULE   * Valuation Rule
     */
    public void setVALUATION_RULE(java.lang.String VALUATION_RULE) {
        this.VALUATION_RULE = VALUATION_RULE;
    }


    /**
     * Gets the OBJECT_ID value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return OBJECT_ID   * ID of Object
     */
    public java.lang.String getOBJECT_ID() {
        return OBJECT_ID;
    }


    /**
     * Sets the OBJECT_ID value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param OBJECT_ID   * ID of Object
     */
    public void setOBJECT_ID(java.lang.String OBJECT_ID) {
        this.OBJECT_ID = OBJECT_ID;
    }


    /**
     * Gets the OBJECT_TYPE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return OBJECT_TYPE   * Business Object Type of Object
     */
    public java.lang.String getOBJECT_TYPE() {
        return OBJECT_TYPE;
    }


    /**
     * Sets the OBJECT_TYPE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param OBJECT_TYPE   * Business Object Type of Object
     */
    public void setOBJECT_TYPE(java.lang.String OBJECT_TYPE) {
        this.OBJECT_TYPE = OBJECT_TYPE;
    }


    /**
     * Gets the OBJECT_VALID_FROM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return OBJECT_VALID_FROM   * Object Valid From
     */
    public java.lang.String getOBJECT_VALID_FROM() {
        return OBJECT_VALID_FROM;
    }


    /**
     * Sets the OBJECT_VALID_FROM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param OBJECT_VALID_FROM   * Object Valid From
     */
    public void setOBJECT_VALID_FROM(java.lang.String OBJECT_VALID_FROM) {
        this.OBJECT_VALID_FROM = OBJECT_VALID_FROM;
    }


    /**
     * Gets the OBJECT_VALID_TO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return OBJECT_VALID_TO   * Object Valid To
     */
    public java.lang.String getOBJECT_VALID_TO() {
        return OBJECT_VALID_TO;
    }


    /**
     * Sets the OBJECT_VALID_TO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param OBJECT_VALID_TO   * Object Valid To
     */
    public void setOBJECT_VALID_TO(java.lang.String OBJECT_VALID_TO) {
        this.OBJECT_VALID_TO = OBJECT_VALID_TO;
    }


    /**
     * Gets the START_DATE_OF_CONSIDERATION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return START_DATE_OF_CONSIDERATION   * Start of Consideration
     */
    public java.lang.String getSTART_DATE_OF_CONSIDERATION() {
        return START_DATE_OF_CONSIDERATION;
    }


    /**
     * Sets the START_DATE_OF_CONSIDERATION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param START_DATE_OF_CONSIDERATION   * Start of Consideration
     */
    public void setSTART_DATE_OF_CONSIDERATION(java.lang.String START_DATE_OF_CONSIDERATION) {
        this.START_DATE_OF_CONSIDERATION = START_DATE_OF_CONSIDERATION;
    }


    /**
     * Gets the FIRST_POSTING_FROM1 value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return FIRST_POSTING_FROM1   * First Posting From
     */
    public java.lang.String getFIRST_POSTING_FROM1() {
        return FIRST_POSTING_FROM1;
    }


    /**
     * Sets the FIRST_POSTING_FROM1 value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param FIRST_POSTING_FROM1   * First Posting From
     */
    public void setFIRST_POSTING_FROM1(java.lang.String FIRST_POSTING_FROM1) {
        this.FIRST_POSTING_FROM1 = FIRST_POSTING_FROM1;
    }


    /**
     * Gets the CLASSIFICATION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CLASSIFICATION   * Classification
     */
    public java.lang.String getCLASSIFICATION() {
        return CLASSIFICATION;
    }


    /**
     * Sets the CLASSIFICATION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CLASSIFICATION   * Classification
     */
    public void setCLASSIFICATION(java.lang.String CLASSIFICATION) {
        this.CLASSIFICATION = CLASSIFICATION;
    }


    /**
     * Gets the INTEREST_RATE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return INTEREST_RATE   * Interest Rate
     */
    public java.math.BigDecimal getINTEREST_RATE() {
        return INTEREST_RATE;
    }


    /**
     * Sets the INTEREST_RATE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param INTEREST_RATE   * Interest Rate
     */
    public void setINTEREST_RATE(java.math.BigDecimal INTEREST_RATE) {
        this.INTEREST_RATE = INTEREST_RATE;
    }


    /**
     * Gets the FREQUENCY_TERM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return FREQUENCY_TERM   * Number of Frequency Term
     */
    public java.lang.String getFREQUENCY_TERM() {
        return FREQUENCY_TERM;
    }


    /**
     * Sets the FREQUENCY_TERM value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param FREQUENCY_TERM   * Number of Frequency Term
     */
    public void setFREQUENCY_TERM(java.lang.String FREQUENCY_TERM) {
        this.FREQUENCY_TERM = FREQUENCY_TERM;
    }


    /**
     * Gets the DISTRIBUT_FORMULA value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return DISTRIBUT_FORMULA   * Distribution Formula
     */
    public java.lang.String getDISTRIBUT_FORMULA() {
        return DISTRIBUT_FORMULA;
    }


    /**
     * Sets the DISTRIBUT_FORMULA value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param DISTRIBUT_FORMULA   * Distribution Formula
     */
    public void setDISTRIBUT_FORMULA(java.lang.String DISTRIBUT_FORMULA) {
        this.DISTRIBUT_FORMULA = DISTRIBUT_FORMULA;
    }


    /**
     * Gets the DISTRIB_FORMULA_PARAMETER value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return DISTRIB_FORMULA_PARAMETER   * Untypified Parameter for a Distribution Formula
     */
    public java.lang.String getDISTRIB_FORMULA_PARAMETER() {
        return DISTRIB_FORMULA_PARAMETER;
    }


    /**
     * Sets the DISTRIB_FORMULA_PARAMETER value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param DISTRIB_FORMULA_PARAMETER   * Untypified Parameter for a Distribution Formula
     */
    public void setDISTRIB_FORMULA_PARAMETER(java.lang.String DISTRIB_FORMULA_PARAMETER) {
        this.DISTRIB_FORMULA_PARAMETER = DISTRIB_FORMULA_PARAMETER;
    }


    /**
     * Gets the PROBABLE_END value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return PROBABLE_END
     */
    public java.lang.String getPROBABLE_END() {
        return PROBABLE_END;
    }


    /**
     * Sets the PROBABLE_END value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param PROBABLE_END
     */
    public void setPROBABLE_END(java.lang.String PROBABLE_END) {
        this.PROBABLE_END = PROBABLE_END;
    }


    /**
     * Gets the END_OF_USAGE_ROU value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return END_OF_USAGE_ROU   * End of Usage RoU
     */
    public java.lang.String getEND_OF_USAGE_ROU() {
        return END_OF_USAGE_ROU;
    }


    /**
     * Sets the END_OF_USAGE_ROU value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param END_OF_USAGE_ROU   * End of Usage RoU
     */
    public void setEND_OF_USAGE_ROU(java.lang.String END_OF_USAGE_ROU) {
        this.END_OF_USAGE_ROU = END_OF_USAGE_ROU;
    }


    /**
     * Gets the VALUATION_STATUS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return VALUATION_STATUS   * Status Reason for Valuation Rule
     */
    public java.lang.String getVALUATION_STATUS() {
        return VALUATION_STATUS;
    }


    /**
     * Sets the VALUATION_STATUS value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param VALUATION_STATUS   * Status Reason for Valuation Rule
     */
    public void setVALUATION_STATUS(java.lang.String VALUATION_STATUS) {
        this.VALUATION_STATUS = VALUATION_STATUS;
    }


    /**
     * Gets the VALUATION_BEHAVIOR value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return VALUATION_BEHAVIOR   * Valuation Behavior
     */
    public java.lang.String getVALUATION_BEHAVIOR() {
        return VALUATION_BEHAVIOR;
    }


    /**
     * Sets the VALUATION_BEHAVIOR value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param VALUATION_BEHAVIOR   * Valuation Behavior
     */
    public void setVALUATION_BEHAVIOR(java.lang.String VALUATION_BEHAVIOR) {
        this.VALUATION_BEHAVIOR = VALUATION_BEHAVIOR;
    }


    /**
     * Gets the COMPANY_CODE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return COMPANY_CODE   * Company Code
     */
    public java.lang.String getCOMPANY_CODE() {
        return COMPANY_CODE;
    }


    /**
     * Sets the COMPANY_CODE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param COMPANY_CODE   * Company Code
     */
    public void setCOMPANY_CODE(java.lang.String COMPANY_CODE) {
        this.COMPANY_CODE = COMPANY_CODE;
    }


    /**
     * Gets the ASSET value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return ASSET   * ID of Object
     */
    public java.lang.String getASSET() {
        return ASSET;
    }


    /**
     * Sets the ASSET value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param ASSET   * ID of Object
     */
    public void setASSET(java.lang.String ASSET) {
        this.ASSET = ASSET;
    }


    /**
     * Gets the SUBNO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return SUBNO   * Subnumber
     */
    public java.lang.String getSUBNO() {
        return SUBNO;
    }


    /**
     * Sets the SUBNO value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param SUBNO   * Subnumber
     */
    public void setSUBNO(java.lang.String SUBNO) {
        this.SUBNO = SUBNO;
    }


    /**
     * Gets the OBJECT_DESCRIPTION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return OBJECT_DESCRIPTION   * Object Description
     */
    public java.lang.String getOBJECT_DESCRIPTION() {
        return OBJECT_DESCRIPTION;
    }


    /**
     * Sets the OBJECT_DESCRIPTION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param OBJECT_DESCRIPTION   * Object Description
     */
    public void setOBJECT_DESCRIPTION(java.lang.String OBJECT_DESCRIPTION) {
        this.OBJECT_DESCRIPTION = OBJECT_DESCRIPTION;
    }


    /**
     * Gets the ACCTASGOBJTYPE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return ACCTASGOBJTYPE   * Business Object Type of Object
     */
    public java.lang.String getACCTASGOBJTYPE() {
        return ACCTASGOBJTYPE;
    }


    /**
     * Sets the ACCTASGOBJTYPE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param ACCTASGOBJTYPE   * Business Object Type of Object
     */
    public void setACCTASGOBJTYPE(java.lang.String ACCTASGOBJTYPE) {
        this.ACCTASGOBJTYPE = ACCTASGOBJTYPE;
    }


    /**
     * Gets the ABSOLUTE_START value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return ABSOLUTE_START   * Absolute Start
     */
    public java.lang.String getABSOLUTE_START() {
        return ABSOLUTE_START;
    }


    /**
     * Sets the ABSOLUTE_START value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param ABSOLUTE_START   * Absolute Start
     */
    public void setABSOLUTE_START(java.lang.String ABSOLUTE_START) {
        this.ABSOLUTE_START = ABSOLUTE_START;
    }


    /**
     * Gets the ABSOLUTE_END value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return ABSOLUTE_END   * Absolute End
     */
    public java.lang.String getABSOLUTE_END() {
        return ABSOLUTE_END;
    }


    /**
     * Sets the ABSOLUTE_END value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param ABSOLUTE_END   * Absolute End
     */
    public void setABSOLUTE_END(java.lang.String ABSOLUTE_END) {
        this.ABSOLUTE_END = ABSOLUTE_END;
    }


    /**
     * Gets the COND_VAL_PROPERTY value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return COND_VAL_PROPERTY   * Condition Valuation Property
     */
    public java.lang.String getCOND_VAL_PROPERTY() {
        return COND_VAL_PROPERTY;
    }


    /**
     * Sets the COND_VAL_PROPERTY value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param COND_VAL_PROPERTY   * Condition Valuation Property
     */
    public void setCOND_VAL_PROPERTY(java.lang.String COND_VAL_PROPERTY) {
        this.COND_VAL_PROPERTY = COND_VAL_PROPERTY;
    }


    /**
     * Gets the COND_CONSIDERATION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return COND_CONSIDERATION   * Condition Consideration
     */
    public java.lang.String getCOND_CONSIDERATION() {
        return COND_CONSIDERATION;
    }


    /**
     * Sets the COND_CONSIDERATION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param COND_CONSIDERATION   * Condition Consideration
     */
    public void setCOND_CONSIDERATION(java.lang.String COND_CONSIDERATION) {
        this.COND_CONSIDERATION = COND_CONSIDERATION;
    }


    /**
     * Gets the CONSIDER_CONDITION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONSIDER_CONDITION   * Indicator: Consider Condition?
     */
    public java.lang.String getCONSIDER_CONDITION() {
        return CONSIDER_CONDITION;
    }


    /**
     * Sets the CONSIDER_CONDITION value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONSIDER_CONDITION   * Indicator: Consider Condition?
     */
    public void setCONSIDER_CONDITION(java.lang.String CONSIDER_CONDITION) {
        this.CONSIDER_CONDITION = CONSIDER_CONDITION;
    }


    /**
     * Gets the PERCENTAGE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return PERCENTAGE   * Percentage
     */
    public java.lang.String getPERCENTAGE() {
        return PERCENTAGE;
    }


    /**
     * Sets the PERCENTAGE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param PERCENTAGE   * Percentage
     */
    public void setPERCENTAGE(java.lang.String PERCENTAGE) {
        this.PERCENTAGE = PERCENTAGE;
    }


    /**
     * Gets the ABSOLUTE_SHARE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return ABSOLUTE_SHARE   * Absolute Share
     */
    public java.lang.String getABSOLUTE_SHARE() {
        return ABSOLUTE_SHARE;
    }


    /**
     * Sets the ABSOLUTE_SHARE value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param ABSOLUTE_SHARE   * Absolute Share
     */
    public void setABSOLUTE_SHARE(java.lang.String ABSOLUTE_SHARE) {
        this.ABSOLUTE_SHARE = ABSOLUTE_SHARE;
    }


    /**
     * Gets the CURRENCY value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CURRENCY   * Currency for Contract
     */
    public java.lang.String getCURRENCY() {
        return CURRENCY;
    }


    /**
     * Sets the CURRENCY value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CURRENCY   * Currency for Contract
     */
    public void setCURRENCY(java.lang.String CURRENCY) {
        this.CURRENCY = CURRENCY;
    }


    /**
     * Gets the CONDITION_PURPOSE1 value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return CONDITION_PURPOSE1   * Conditions - External Purpose
     */
    public java.lang.String getCONDITION_PURPOSE1() {
        return CONDITION_PURPOSE1;
    }


    /**
     * Sets the CONDITION_PURPOSE1 value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param CONDITION_PURPOSE1   * Conditions - External Purpose
     */
    public void setCONDITION_PURPOSE1(java.lang.String CONDITION_PURPOSE1) {
        this.CONDITION_PURPOSE1 = CONDITION_PURPOSE1;
    }


    /**
     * Gets the UNIT_PRICE1 value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @return UNIT_PRICE1   * Unit Price
     */
    public java.math.BigDecimal getUNIT_PRICE1() {
        return UNIT_PRICE1;
    }


    /**
     * Sets the UNIT_PRICE1 value for this ZREIF_S_SEM_CONTRACT_CHANGE_IN.
     * 
     * @param UNIT_PRICE1   * Unit Price
     */
    public void setUNIT_PRICE1(java.math.BigDecimal UNIT_PRICE1) {
        this.UNIT_PRICE1 = UNIT_PRICE1;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZREIF_S_SEM_CONTRACT_CHANGE_IN)) return false;
        ZREIF_S_SEM_CONTRACT_CHANGE_IN other = (ZREIF_S_SEM_CONTRACT_CHANGE_IN) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.FILENAME==null && other.getFILENAME()==null) || 
             (this.FILENAME!=null &&
              this.FILENAME.equals(other.getFILENAME()))) &&
            ((this.REFERENCE_ID==null && other.getREFERENCE_ID()==null) || 
             (this.REFERENCE_ID!=null &&
              this.REFERENCE_ID.equals(other.getREFERENCE_ID()))) &&
            ((this.ACTIVITY==null && other.getACTIVITY()==null) || 
             (this.ACTIVITY!=null &&
              this.ACTIVITY.equals(other.getACTIVITY()))) &&
            ((this.COMP_CODE==null && other.getCOMP_CODE()==null) || 
             (this.COMP_CODE!=null &&
              this.COMP_CODE.equals(other.getCOMP_CODE()))) &&
            ((this.CONTRACT_NO==null && other.getCONTRACT_NO()==null) || 
             (this.CONTRACT_NO!=null &&
              this.CONTRACT_NO.equals(other.getCONTRACT_NO()))) &&
            ((this.COMPANY_CODE_MAIN==null && other.getCOMPANY_CODE_MAIN()==null) || 
             (this.COMPANY_CODE_MAIN!=null &&
              this.COMPANY_CODE_MAIN.equals(other.getCOMPANY_CODE_MAIN()))) &&
            ((this.MAIN_CONTRACT_NO==null && other.getMAIN_CONTRACT_NO()==null) || 
             (this.MAIN_CONTRACT_NO!=null &&
              this.MAIN_CONTRACT_NO.equals(other.getMAIN_CONTRACT_NO()))) &&
            ((this.OLD_CONTRACT_NO==null && other.getOLD_CONTRACT_NO()==null) || 
             (this.OLD_CONTRACT_NO!=null &&
              this.OLD_CONTRACT_NO.equals(other.getOLD_CONTRACT_NO()))) &&
            ((this.CONTRACT_TYPE==null && other.getCONTRACT_TYPE()==null) || 
             (this.CONTRACT_TYPE!=null &&
              this.CONTRACT_TYPE.equals(other.getCONTRACT_TYPE()))) &&
            ((this.OBJECT_DESC==null && other.getOBJECT_DESC()==null) || 
             (this.OBJECT_DESC!=null &&
              this.OBJECT_DESC.equals(other.getOBJECT_DESC()))) &&
            ((this.CONTRACT_NAME==null && other.getCONTRACT_NAME()==null) || 
             (this.CONTRACT_NAME!=null &&
              this.CONTRACT_NAME.equals(other.getCONTRACT_NAME()))) &&
            ((this.CONTRACT_CONCLUSION_DATE==null && other.getCONTRACT_CONCLUSION_DATE()==null) || 
             (this.CONTRACT_CONCLUSION_DATE!=null &&
              this.CONTRACT_CONCLUSION_DATE.equals(other.getCONTRACT_CONCLUSION_DATE()))) &&
            ((this.DATE_CONTRACT_START==null && other.getDATE_CONTRACT_START()==null) || 
             (this.DATE_CONTRACT_START!=null &&
              this.DATE_CONTRACT_START.equals(other.getDATE_CONTRACT_START()))) &&
            ((this.DATE_FIRST_CONTRACT_END==null && other.getDATE_FIRST_CONTRACT_END()==null) || 
             (this.DATE_FIRST_CONTRACT_END!=null &&
              this.DATE_FIRST_CONTRACT_END.equals(other.getDATE_FIRST_CONTRACT_END()))) &&
            ((this.AUTHORIZATION_GROUP==null && other.getAUTHORIZATION_GROUP()==null) || 
             (this.AUTHORIZATION_GROUP!=null &&
              this.AUTHORIZATION_GROUP.equals(other.getAUTHORIZATION_GROUP()))) &&
            ((this.INDUSTRY==null && other.getINDUSTRY()==null) || 
             (this.INDUSTRY!=null &&
              this.INDUSTRY.equals(other.getINDUSTRY()))) &&
            ((this.PERSON_RESPONSIBLE==null && other.getPERSON_RESPONSIBLE()==null) || 
             (this.PERSON_RESPONSIBLE!=null &&
              this.PERSON_RESPONSIBLE.equals(other.getPERSON_RESPONSIBLE()))) &&
            ((this.CASH_FLOW_STARTING_ON==null && other.getCASH_FLOW_STARTING_ON()==null) || 
             (this.CASH_FLOW_STARTING_ON!=null &&
              this.CASH_FLOW_STARTING_ON.equals(other.getCASH_FLOW_STARTING_ON()))) &&
            ((this.FIRST_POSTING_FROM==null && other.getFIRST_POSTING_FROM()==null) || 
             (this.FIRST_POSTING_FROM!=null &&
              this.FIRST_POSTING_FROM.equals(other.getFIRST_POSTING_FROM()))) &&
            ((this.CURRENCY_FOR_CONTRACT==null && other.getCURRENCY_FOR_CONTRACT()==null) || 
             (this.CURRENCY_FOR_CONTRACT!=null &&
              this.CURRENCY_FOR_CONTRACT.equals(other.getCURRENCY_FOR_CONTRACT()))) &&
            ((this.TYPE_OF_RENEWAL==null && other.getTYPE_OF_RENEWAL()==null) || 
             (this.TYPE_OF_RENEWAL!=null &&
              this.TYPE_OF_RENEWAL.equals(other.getTYPE_OF_RENEWAL()))) &&
            ((this.RENEWAL_RULE==null && other.getRENEWAL_RULE()==null) || 
             (this.RENEWAL_RULE!=null &&
              this.RENEWAL_RULE.equals(other.getRENEWAL_RULE()))) &&
            ((this.SEQUENCE_NO==null && other.getSEQUENCE_NO()==null) || 
             (this.SEQUENCE_NO!=null &&
              this.SEQUENCE_NO.equals(other.getSEQUENCE_NO()))) &&
            ((this.NO_OF_RENEWALS==null && other.getNO_OF_RENEWALS()==null) || 
             (this.NO_OF_RENEWALS!=null &&
              this.NO_OF_RENEWALS.equals(other.getNO_OF_RENEWALS()))) &&
            ((this.CONTRACT_RENEWED_YEARS==null && other.getCONTRACT_RENEWED_YEARS()==null) || 
             (this.CONTRACT_RENEWED_YEARS!=null &&
              this.CONTRACT_RENEWED_YEARS.equals(other.getCONTRACT_RENEWED_YEARS()))) &&
            ((this.CONTRACT_RENEWED_MONTHS==null && other.getCONTRACT_RENEWED_MONTHS()==null) || 
             (this.CONTRACT_RENEWED_MONTHS!=null &&
              this.CONTRACT_RENEWED_MONTHS.equals(other.getCONTRACT_RENEWED_MONTHS()))) &&
            ((this.CONTRACT_RENEWED_DAYS==null && other.getCONTRACT_RENEWED_DAYS()==null) || 
             (this.CONTRACT_RENEWED_DAYS!=null &&
              this.CONTRACT_RENEWED_DAYS.equals(other.getCONTRACT_RENEWED_DAYS()))) &&
            ((this.TYPE_OF_AUTOMATIC_RENEWAL==null && other.getTYPE_OF_AUTOMATIC_RENEWAL()==null) || 
             (this.TYPE_OF_AUTOMATIC_RENEWAL!=null &&
              this.TYPE_OF_AUTOMATIC_RENEWAL.equals(other.getTYPE_OF_AUTOMATIC_RENEWAL()))) &&
            ((this.RENEWAL_EXECUTION==null && other.getRENEWAL_EXECUTION()==null) || 
             (this.RENEWAL_EXECUTION!=null &&
              this.RENEWAL_EXECUTION.equals(other.getRENEWAL_EXECUTION()))) &&
            ((this.TERM_NO==null && other.getTERM_NO()==null) || 
             (this.TERM_NO!=null &&
              this.TERM_NO.equals(other.getTERM_NO()))) &&
            ((this.PAYMENT_METHOD==null && other.getPAYMENT_METHOD()==null) || 
             (this.PAYMENT_METHOD!=null &&
              this.PAYMENT_METHOD.equals(other.getPAYMENT_METHOD()))) &&
            ((this.PMT_METHSUPL==null && other.getPMT_METHSUPL()==null) || 
             (this.PMT_METHSUPL!=null &&
              this.PMT_METHSUPL.equals(other.getPMT_METHSUPL()))) &&
            ((this.INDIVID_SET==null && other.getINDIVID_SET()==null) || 
             (this.INDIVID_SET!=null &&
              this.INDIVID_SET.equals(other.getINDIVID_SET()))) &&
            ((this.PAYMENT_BLOCK_KEY==null && other.getPAYMENT_BLOCK_KEY()==null) || 
             (this.PAYMENT_BLOCK_KEY!=null &&
              this.PAYMENT_BLOCK_KEY.equals(other.getPAYMENT_BLOCK_KEY()))) &&
            ((this.TERMS_OF_PAYMENT_KEY==null && other.getTERMS_OF_PAYMENT_KEY()==null) || 
             (this.TERMS_OF_PAYMENT_KEY!=null &&
              this.TERMS_OF_PAYMENT_KEY.equals(other.getTERMS_OF_PAYMENT_KEY()))) &&
            ((this.KEY_FOR_HOUSE_BANK==null && other.getKEY_FOR_HOUSE_BANK()==null) || 
             (this.KEY_FOR_HOUSE_BANK!=null &&
              this.KEY_FOR_HOUSE_BANK.equals(other.getKEY_FOR_HOUSE_BANK()))) &&
            ((this.BANK_DETAILS_ID==null && other.getBANK_DETAILS_ID()==null) || 
             (this.BANK_DETAILS_ID!=null &&
              this.BANK_DETAILS_ID.equals(other.getBANK_DETAILS_ID()))) &&
            ((this.NOTE_TO_PAYEE==null && other.getNOTE_TO_PAYEE()==null) || 
             (this.NOTE_TO_PAYEE!=null &&
              this.NOTE_TO_PAYEE.equals(other.getNOTE_TO_PAYEE()))) &&
            ((this.DUNNING_AREA==null && other.getDUNNING_AREA()==null) || 
             (this.DUNNING_AREA!=null &&
              this.DUNNING_AREA.equals(other.getDUNNING_AREA()))) &&
            ((this.DUNNING_BLOCK==null && other.getDUNNING_BLOCK()==null) || 
             (this.DUNNING_BLOCK!=null &&
              this.DUNNING_BLOCK.equals(other.getDUNNING_BLOCK()))) &&
            ((this.ACCOUNT_DETERMINATION==null && other.getACCOUNT_DETERMINATION()==null) || 
             (this.ACCOUNT_DETERMINATION!=null &&
              this.ACCOUNT_DETERMINATION.equals(other.getACCOUNT_DETERMINATION()))) &&
            ((this.TAX_TYPE==null && other.getTAX_TYPE()==null) || 
             (this.TAX_TYPE!=null &&
              this.TAX_TYPE.equals(other.getTAX_TYPE()))) &&
            ((this.TAX_GROUP==null && other.getTAX_GROUP()==null) || 
             (this.TAX_GROUP!=null &&
              this.TAX_GROUP.equals(other.getTAX_GROUP()))) &&
            ((this.BUSINESS_PARTNER_NO==null && other.getBUSINESS_PARTNER_NO()==null) || 
             (this.BUSINESS_PARTNER_NO!=null &&
              this.BUSINESS_PARTNER_NO.equals(other.getBUSINESS_PARTNER_NO()))) &&
            ((this.TERM_NO1==null && other.getTERM_NO1()==null) || 
             (this.TERM_NO1!=null &&
              this.TERM_NO1.equals(other.getTERM_NO1()))) &&
            ((this.FREQUENCY==null && other.getFREQUENCY()==null) || 
             (this.FREQUENCY!=null &&
              this.FREQUENCY.equals(other.getFREQUENCY()))) &&
            ((this.FREQUENCY_UNIT==null && other.getFREQUENCY_UNIT()==null) || 
             (this.FREQUENCY_UNIT!=null &&
              this.FREQUENCY_UNIT.equals(other.getFREQUENCY_UNIT()))) &&
            ((this.STARTING_MONTH==null && other.getSTARTING_MONTH()==null) || 
             (this.STARTING_MONTH!=null &&
              this.STARTING_MONTH.equals(other.getSTARTING_MONTH()))) &&
            ((this.PAYMENT_FORM==null && other.getPAYMENT_FORM()==null) || 
             (this.PAYMENT_FORM!=null &&
              this.PAYMENT_FORM.equals(other.getPAYMENT_FORM()))) &&
            ((this.PRORATED==null && other.getPRORATED()==null) || 
             (this.PRORATED!=null &&
              this.PRORATED.equals(other.getPRORATED()))) &&
            ((this.CALCULATE_METHOD==null && other.getCALCULATE_METHOD()==null) || 
             (this.CALCULATE_METHOD!=null &&
              this.CALCULATE_METHOD.equals(other.getCALCULATE_METHOD()))) &&
            ((this.FACTORY_CALENDAR==null && other.getFACTORY_CALENDAR()==null) || 
             (this.FACTORY_CALENDAR!=null &&
              this.FACTORY_CALENDAR.equals(other.getFACTORY_CALENDAR()))) &&
            ((this.PARTNER_DAT==null && other.getPARTNER_DAT()==null) || 
             (this.PARTNER_DAT!=null &&
              this.PARTNER_DAT.equals(other.getPARTNER_DAT()))) &&
            ((this.ROLE_TYPE==null && other.getROLE_TYPE()==null) || 
             (this.ROLE_TYPE!=null &&
              this.ROLE_TYPE.equals(other.getROLE_TYPE()))) &&
            ((this.DATE_START_RELATIONSHIP==null && other.getDATE_START_RELATIONSHIP()==null) || 
             (this.DATE_START_RELATIONSHIP!=null &&
              this.DATE_START_RELATIONSHIP.equals(other.getDATE_START_RELATIONSHIP()))) &&
            ((this.DATE_END_RELATIONSHIP==null && other.getDATE_END_RELATIONSHIP()==null) || 
             (this.DATE_END_RELATIONSHIP!=null &&
              this.DATE_END_RELATIONSHIP.equals(other.getDATE_END_RELATIONSHIP()))) &&
            ((this.ADDRESS_TYPE==null && other.getADDRESS_TYPE()==null) || 
             (this.ADDRESS_TYPE!=null &&
              this.ADDRESS_TYPE.equals(other.getADDRESS_TYPE()))) &&
            ((this.CONDITION_SPLIT==null && other.getCONDITION_SPLIT()==null) || 
             (this.CONDITION_SPLIT!=null &&
              this.CONDITION_SPLIT.equals(other.getCONDITION_SPLIT()))) &&
            ((this.CONDITION_TYPE==null && other.getCONDITION_TYPE()==null) || 
             (this.CONDITION_TYPE!=null &&
              this.CONDITION_TYPE.equals(other.getCONDITION_TYPE()))) &&
            ((this.CONDITION_PURPOSE==null && other.getCONDITION_PURPOSE()==null) || 
             (this.CONDITION_PURPOSE!=null &&
              this.CONDITION_PURPOSE.equals(other.getCONDITION_PURPOSE()))) &&
            ((this.DATE_FROM_CONDITION==null && other.getDATE_FROM_CONDITION()==null) || 
             (this.DATE_FROM_CONDITION!=null &&
              this.DATE_FROM_CONDITION.equals(other.getDATE_FROM_CONDITION()))) &&
            ((this.DATE_UP_TO_CONDITION==null && other.getDATE_UP_TO_CONDITION()==null) || 
             (this.DATE_UP_TO_CONDITION!=null &&
              this.DATE_UP_TO_CONDITION.equals(other.getDATE_UP_TO_CONDITION()))) &&
            ((this.CURRENCY_CONDITION==null && other.getCURRENCY_CONDITION()==null) || 
             (this.CURRENCY_CONDITION!=null &&
              this.CURRENCY_CONDITION.equals(other.getCURRENCY_CONDITION()))) &&
            ((this.NO_POSTING_TERM==null && other.getNO_POSTING_TERM()==null) || 
             (this.NO_POSTING_TERM!=null &&
              this.NO_POSTING_TERM.equals(other.getNO_POSTING_TERM()))) &&
            ((this.NO_FREQUENCY_TERM==null && other.getNO_FREQUENCY_TERM()==null) || 
             (this.NO_FREQUENCY_TERM!=null &&
              this.NO_FREQUENCY_TERM.equals(other.getNO_FREQUENCY_TERM()))) &&
            ((this.NO_ORGANIZATIONAL_TERM==null && other.getNO_ORGANIZATIONAL_TERM()==null) || 
             (this.NO_ORGANIZATIONAL_TERM!=null &&
              this.NO_ORGANIZATIONAL_TERM.equals(other.getNO_ORGANIZATIONAL_TERM()))) &&
            ((this.COST_CENTER==null && other.getCOST_CENTER()==null) || 
             (this.COST_CENTER!=null &&
              this.COST_CENTER.equals(other.getCOST_CENTER()))) &&
            ((this.PROFIT_CENTER==null && other.getPROFIT_CENTER()==null) || 
             (this.PROFIT_CENTER!=null &&
              this.PROFIT_CENTER.equals(other.getPROFIT_CENTER()))) &&
            ((this.CALCULATION_FORMULA==null && other.getCALCULATION_FORMULA()==null) || 
             (this.CALCULATION_FORMULA!=null &&
              this.CALCULATION_FORMULA.equals(other.getCALCULATION_FORMULA()))) &&
            ((this.CURRENCY_UNIT_PRICE==null && other.getCURRENCY_UNIT_PRICE()==null) || 
             (this.CURRENCY_UNIT_PRICE!=null &&
              this.CURRENCY_UNIT_PRICE.equals(other.getCURRENCY_UNIT_PRICE()))) &&
            ((this.DISTRIBUTION_FORMULA==null && other.getDISTRIBUTION_FORMULA()==null) || 
             (this.DISTRIBUTION_FORMULA!=null &&
              this.DISTRIBUTION_FORMULA.equals(other.getDISTRIBUTION_FORMULA()))) &&
            ((this.CONDITIONS_EXTERNAL_PURPOSE==null && other.getCONDITIONS_EXTERNAL_PURPOSE()==null) || 
             (this.CONDITIONS_EXTERNAL_PURPOSE!=null &&
              this.CONDITIONS_EXTERNAL_PURPOSE.equals(other.getCONDITIONS_EXTERNAL_PURPOSE()))) &&
            ((this.CONDITION_ONE_TIME1==null && other.getCONDITION_ONE_TIME1()==null) || 
             (this.CONDITION_ONE_TIME1!=null &&
              this.CONDITION_ONE_TIME1.equals(other.getCONDITION_ONE_TIME1()))) &&
            ((this.STATISTICAL_INFO_CONDITION1==null && other.getSTATISTICAL_INFO_CONDITION1()==null) || 
             (this.STATISTICAL_INFO_CONDITION1!=null &&
              this.STATISTICAL_INFO_CONDITION1.equals(other.getSTATISTICAL_INFO_CONDITION1()))) &&
            ((this.POSTING_START_DATE_CONDITION==null && other.getPOSTING_START_DATE_CONDITION()==null) || 
             (this.POSTING_START_DATE_CONDITION!=null &&
              this.POSTING_START_DATE_CONDITION.equals(other.getPOSTING_START_DATE_CONDITION()))) &&
            ((this.NO_OF_WHT_TERM==null && other.getNO_OF_WHT_TERM()==null) || 
             (this.NO_OF_WHT_TERM!=null &&
              this.NO_OF_WHT_TERM.equals(other.getNO_OF_WHT_TERM()))) &&
            ((this.DIFFERENT_DUE_DATE_ONE_TIME==null && other.getDIFFERENT_DUE_DATE_ONE_TIME()==null) || 
             (this.DIFFERENT_DUE_DATE_ONE_TIME!=null &&
              this.DIFFERENT_DUE_DATE_ONE_TIME.equals(other.getDIFFERENT_DUE_DATE_ONE_TIME()))) &&
            ((this.GRADING_TERM_IN_MONTHS==null && other.getGRADING_TERM_IN_MONTHS()==null) || 
             (this.GRADING_TERM_IN_MONTHS!=null &&
              this.GRADING_TERM_IN_MONTHS.equals(other.getGRADING_TERM_IN_MONTHS()))) &&
            ((this.GRADING_INTERVAL_MONTHS==null && other.getGRADING_INTERVAL_MONTHS()==null) || 
             (this.GRADING_INTERVAL_MONTHS!=null &&
              this.GRADING_INTERVAL_MONTHS.equals(other.getGRADING_INTERVAL_MONTHS()))) &&
            ((this.GRADING_PERCENT_INCREASE==null && other.getGRADING_PERCENT_INCREASE()==null) || 
             (this.GRADING_PERCENT_INCREASE!=null &&
              this.GRADING_PERCENT_INCREASE.equals(other.getGRADING_PERCENT_INCREASE()))) &&
            ((this.GRADING_ABSOLUTE_INCREASE==null && other.getGRADING_ABSOLUTE_INCREASE()==null) || 
             (this.GRADING_ABSOLUTE_INCREASE!=null &&
              this.GRADING_ABSOLUTE_INCREASE.equals(other.getGRADING_ABSOLUTE_INCREASE()))) &&
            ((this.CONTRACT_STATUS==null && other.getCONTRACT_STATUS()==null) || 
             (this.CONTRACT_STATUS!=null &&
              this.CONTRACT_STATUS.equals(other.getCONTRACT_STATUS()))) &&
            ((this.VALUATION_RULE==null && other.getVALUATION_RULE()==null) || 
             (this.VALUATION_RULE!=null &&
              this.VALUATION_RULE.equals(other.getVALUATION_RULE()))) &&
            ((this.OBJECT_ID==null && other.getOBJECT_ID()==null) || 
             (this.OBJECT_ID!=null &&
              this.OBJECT_ID.equals(other.getOBJECT_ID()))) &&
            ((this.OBJECT_TYPE==null && other.getOBJECT_TYPE()==null) || 
             (this.OBJECT_TYPE!=null &&
              this.OBJECT_TYPE.equals(other.getOBJECT_TYPE()))) &&
            ((this.OBJECT_VALID_FROM==null && other.getOBJECT_VALID_FROM()==null) || 
             (this.OBJECT_VALID_FROM!=null &&
              this.OBJECT_VALID_FROM.equals(other.getOBJECT_VALID_FROM()))) &&
            ((this.OBJECT_VALID_TO==null && other.getOBJECT_VALID_TO()==null) || 
             (this.OBJECT_VALID_TO!=null &&
              this.OBJECT_VALID_TO.equals(other.getOBJECT_VALID_TO()))) &&
            ((this.START_DATE_OF_CONSIDERATION==null && other.getSTART_DATE_OF_CONSIDERATION()==null) || 
             (this.START_DATE_OF_CONSIDERATION!=null &&
              this.START_DATE_OF_CONSIDERATION.equals(other.getSTART_DATE_OF_CONSIDERATION()))) &&
            ((this.FIRST_POSTING_FROM1==null && other.getFIRST_POSTING_FROM1()==null) || 
             (this.FIRST_POSTING_FROM1!=null &&
              this.FIRST_POSTING_FROM1.equals(other.getFIRST_POSTING_FROM1()))) &&
            ((this.CLASSIFICATION==null && other.getCLASSIFICATION()==null) || 
             (this.CLASSIFICATION!=null &&
              this.CLASSIFICATION.equals(other.getCLASSIFICATION()))) &&
            ((this.INTEREST_RATE==null && other.getINTEREST_RATE()==null) || 
             (this.INTEREST_RATE!=null &&
              this.INTEREST_RATE.equals(other.getINTEREST_RATE()))) &&
            ((this.FREQUENCY_TERM==null && other.getFREQUENCY_TERM()==null) || 
             (this.FREQUENCY_TERM!=null &&
              this.FREQUENCY_TERM.equals(other.getFREQUENCY_TERM()))) &&
            ((this.DISTRIBUT_FORMULA==null && other.getDISTRIBUT_FORMULA()==null) || 
             (this.DISTRIBUT_FORMULA!=null &&
              this.DISTRIBUT_FORMULA.equals(other.getDISTRIBUT_FORMULA()))) &&
            ((this.DISTRIB_FORMULA_PARAMETER==null && other.getDISTRIB_FORMULA_PARAMETER()==null) || 
             (this.DISTRIB_FORMULA_PARAMETER!=null &&
              this.DISTRIB_FORMULA_PARAMETER.equals(other.getDISTRIB_FORMULA_PARAMETER()))) &&
            ((this.PROBABLE_END==null && other.getPROBABLE_END()==null) || 
             (this.PROBABLE_END!=null &&
              this.PROBABLE_END.equals(other.getPROBABLE_END()))) &&
            ((this.END_OF_USAGE_ROU==null && other.getEND_OF_USAGE_ROU()==null) || 
             (this.END_OF_USAGE_ROU!=null &&
              this.END_OF_USAGE_ROU.equals(other.getEND_OF_USAGE_ROU()))) &&
            ((this.VALUATION_STATUS==null && other.getVALUATION_STATUS()==null) || 
             (this.VALUATION_STATUS!=null &&
              this.VALUATION_STATUS.equals(other.getVALUATION_STATUS()))) &&
            ((this.VALUATION_BEHAVIOR==null && other.getVALUATION_BEHAVIOR()==null) || 
             (this.VALUATION_BEHAVIOR!=null &&
              this.VALUATION_BEHAVIOR.equals(other.getVALUATION_BEHAVIOR()))) &&
            ((this.COMPANY_CODE==null && other.getCOMPANY_CODE()==null) || 
             (this.COMPANY_CODE!=null &&
              this.COMPANY_CODE.equals(other.getCOMPANY_CODE()))) &&
            ((this.ASSET==null && other.getASSET()==null) || 
             (this.ASSET!=null &&
              this.ASSET.equals(other.getASSET()))) &&
            ((this.SUBNO==null && other.getSUBNO()==null) || 
             (this.SUBNO!=null &&
              this.SUBNO.equals(other.getSUBNO()))) &&
            ((this.OBJECT_DESCRIPTION==null && other.getOBJECT_DESCRIPTION()==null) || 
             (this.OBJECT_DESCRIPTION!=null &&
              this.OBJECT_DESCRIPTION.equals(other.getOBJECT_DESCRIPTION()))) &&
            ((this.ACCTASGOBJTYPE==null && other.getACCTASGOBJTYPE()==null) || 
             (this.ACCTASGOBJTYPE!=null &&
              this.ACCTASGOBJTYPE.equals(other.getACCTASGOBJTYPE()))) &&
            ((this.ABSOLUTE_START==null && other.getABSOLUTE_START()==null) || 
             (this.ABSOLUTE_START!=null &&
              this.ABSOLUTE_START.equals(other.getABSOLUTE_START()))) &&
            ((this.ABSOLUTE_END==null && other.getABSOLUTE_END()==null) || 
             (this.ABSOLUTE_END!=null &&
              this.ABSOLUTE_END.equals(other.getABSOLUTE_END()))) &&
            ((this.COND_VAL_PROPERTY==null && other.getCOND_VAL_PROPERTY()==null) || 
             (this.COND_VAL_PROPERTY!=null &&
              this.COND_VAL_PROPERTY.equals(other.getCOND_VAL_PROPERTY()))) &&
            ((this.COND_CONSIDERATION==null && other.getCOND_CONSIDERATION()==null) || 
             (this.COND_CONSIDERATION!=null &&
              this.COND_CONSIDERATION.equals(other.getCOND_CONSIDERATION()))) &&
            ((this.CONSIDER_CONDITION==null && other.getCONSIDER_CONDITION()==null) || 
             (this.CONSIDER_CONDITION!=null &&
              this.CONSIDER_CONDITION.equals(other.getCONSIDER_CONDITION()))) &&
            ((this.PERCENTAGE==null && other.getPERCENTAGE()==null) || 
             (this.PERCENTAGE!=null &&
              this.PERCENTAGE.equals(other.getPERCENTAGE()))) &&
            ((this.ABSOLUTE_SHARE==null && other.getABSOLUTE_SHARE()==null) || 
             (this.ABSOLUTE_SHARE!=null &&
              this.ABSOLUTE_SHARE.equals(other.getABSOLUTE_SHARE()))) &&
            ((this.CURRENCY==null && other.getCURRENCY()==null) || 
             (this.CURRENCY!=null &&
              this.CURRENCY.equals(other.getCURRENCY()))) &&
            ((this.CONDITION_PURPOSE1==null && other.getCONDITION_PURPOSE1()==null) || 
             (this.CONDITION_PURPOSE1!=null &&
              this.CONDITION_PURPOSE1.equals(other.getCONDITION_PURPOSE1()))) &&
            ((this.UNIT_PRICE1==null && other.getUNIT_PRICE1()==null) || 
             (this.UNIT_PRICE1!=null &&
              this.UNIT_PRICE1.equals(other.getUNIT_PRICE1())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getFILENAME() != null) {
            _hashCode += getFILENAME().hashCode();
        }
        if (getREFERENCE_ID() != null) {
            _hashCode += getREFERENCE_ID().hashCode();
        }
        if (getACTIVITY() != null) {
            _hashCode += getACTIVITY().hashCode();
        }
        if (getCOMP_CODE() != null) {
            _hashCode += getCOMP_CODE().hashCode();
        }
        if (getCONTRACT_NO() != null) {
            _hashCode += getCONTRACT_NO().hashCode();
        }
        if (getCOMPANY_CODE_MAIN() != null) {
            _hashCode += getCOMPANY_CODE_MAIN().hashCode();
        }
        if (getMAIN_CONTRACT_NO() != null) {
            _hashCode += getMAIN_CONTRACT_NO().hashCode();
        }
        if (getOLD_CONTRACT_NO() != null) {
            _hashCode += getOLD_CONTRACT_NO().hashCode();
        }
        if (getCONTRACT_TYPE() != null) {
            _hashCode += getCONTRACT_TYPE().hashCode();
        }
        if (getOBJECT_DESC() != null) {
            _hashCode += getOBJECT_DESC().hashCode();
        }
        if (getCONTRACT_NAME() != null) {
            _hashCode += getCONTRACT_NAME().hashCode();
        }
        if (getCONTRACT_CONCLUSION_DATE() != null) {
            _hashCode += getCONTRACT_CONCLUSION_DATE().hashCode();
        }
        if (getDATE_CONTRACT_START() != null) {
            _hashCode += getDATE_CONTRACT_START().hashCode();
        }
        if (getDATE_FIRST_CONTRACT_END() != null) {
            _hashCode += getDATE_FIRST_CONTRACT_END().hashCode();
        }
        if (getAUTHORIZATION_GROUP() != null) {
            _hashCode += getAUTHORIZATION_GROUP().hashCode();
        }
        if (getINDUSTRY() != null) {
            _hashCode += getINDUSTRY().hashCode();
        }
        if (getPERSON_RESPONSIBLE() != null) {
            _hashCode += getPERSON_RESPONSIBLE().hashCode();
        }
        if (getCASH_FLOW_STARTING_ON() != null) {
            _hashCode += getCASH_FLOW_STARTING_ON().hashCode();
        }
        if (getFIRST_POSTING_FROM() != null) {
            _hashCode += getFIRST_POSTING_FROM().hashCode();
        }
        if (getCURRENCY_FOR_CONTRACT() != null) {
            _hashCode += getCURRENCY_FOR_CONTRACT().hashCode();
        }
        if (getTYPE_OF_RENEWAL() != null) {
            _hashCode += getTYPE_OF_RENEWAL().hashCode();
        }
        if (getRENEWAL_RULE() != null) {
            _hashCode += getRENEWAL_RULE().hashCode();
        }
        if (getSEQUENCE_NO() != null) {
            _hashCode += getSEQUENCE_NO().hashCode();
        }
        if (getNO_OF_RENEWALS() != null) {
            _hashCode += getNO_OF_RENEWALS().hashCode();
        }
        if (getCONTRACT_RENEWED_YEARS() != null) {
            _hashCode += getCONTRACT_RENEWED_YEARS().hashCode();
        }
        if (getCONTRACT_RENEWED_MONTHS() != null) {
            _hashCode += getCONTRACT_RENEWED_MONTHS().hashCode();
        }
        if (getCONTRACT_RENEWED_DAYS() != null) {
            _hashCode += getCONTRACT_RENEWED_DAYS().hashCode();
        }
        if (getTYPE_OF_AUTOMATIC_RENEWAL() != null) {
            _hashCode += getTYPE_OF_AUTOMATIC_RENEWAL().hashCode();
        }
        if (getRENEWAL_EXECUTION() != null) {
            _hashCode += getRENEWAL_EXECUTION().hashCode();
        }
        if (getTERM_NO() != null) {
            _hashCode += getTERM_NO().hashCode();
        }
        if (getPAYMENT_METHOD() != null) {
            _hashCode += getPAYMENT_METHOD().hashCode();
        }
        if (getPMT_METHSUPL() != null) {
            _hashCode += getPMT_METHSUPL().hashCode();
        }
        if (getINDIVID_SET() != null) {
            _hashCode += getINDIVID_SET().hashCode();
        }
        if (getPAYMENT_BLOCK_KEY() != null) {
            _hashCode += getPAYMENT_BLOCK_KEY().hashCode();
        }
        if (getTERMS_OF_PAYMENT_KEY() != null) {
            _hashCode += getTERMS_OF_PAYMENT_KEY().hashCode();
        }
        if (getKEY_FOR_HOUSE_BANK() != null) {
            _hashCode += getKEY_FOR_HOUSE_BANK().hashCode();
        }
        if (getBANK_DETAILS_ID() != null) {
            _hashCode += getBANK_DETAILS_ID().hashCode();
        }
        if (getNOTE_TO_PAYEE() != null) {
            _hashCode += getNOTE_TO_PAYEE().hashCode();
        }
        if (getDUNNING_AREA() != null) {
            _hashCode += getDUNNING_AREA().hashCode();
        }
        if (getDUNNING_BLOCK() != null) {
            _hashCode += getDUNNING_BLOCK().hashCode();
        }
        if (getACCOUNT_DETERMINATION() != null) {
            _hashCode += getACCOUNT_DETERMINATION().hashCode();
        }
        if (getTAX_TYPE() != null) {
            _hashCode += getTAX_TYPE().hashCode();
        }
        if (getTAX_GROUP() != null) {
            _hashCode += getTAX_GROUP().hashCode();
        }
        if (getBUSINESS_PARTNER_NO() != null) {
            _hashCode += getBUSINESS_PARTNER_NO().hashCode();
        }
        if (getTERM_NO1() != null) {
            _hashCode += getTERM_NO1().hashCode();
        }
        if (getFREQUENCY() != null) {
            _hashCode += getFREQUENCY().hashCode();
        }
        if (getFREQUENCY_UNIT() != null) {
            _hashCode += getFREQUENCY_UNIT().hashCode();
        }
        if (getSTARTING_MONTH() != null) {
            _hashCode += getSTARTING_MONTH().hashCode();
        }
        if (getPAYMENT_FORM() != null) {
            _hashCode += getPAYMENT_FORM().hashCode();
        }
        if (getPRORATED() != null) {
            _hashCode += getPRORATED().hashCode();
        }
        if (getCALCULATE_METHOD() != null) {
            _hashCode += getCALCULATE_METHOD().hashCode();
        }
        if (getFACTORY_CALENDAR() != null) {
            _hashCode += getFACTORY_CALENDAR().hashCode();
        }
        if (getPARTNER_DAT() != null) {
            _hashCode += getPARTNER_DAT().hashCode();
        }
        if (getROLE_TYPE() != null) {
            _hashCode += getROLE_TYPE().hashCode();
        }
        if (getDATE_START_RELATIONSHIP() != null) {
            _hashCode += getDATE_START_RELATIONSHIP().hashCode();
        }
        if (getDATE_END_RELATIONSHIP() != null) {
            _hashCode += getDATE_END_RELATIONSHIP().hashCode();
        }
        if (getADDRESS_TYPE() != null) {
            _hashCode += getADDRESS_TYPE().hashCode();
        }
        if (getCONDITION_SPLIT() != null) {
            _hashCode += getCONDITION_SPLIT().hashCode();
        }
        if (getCONDITION_TYPE() != null) {
            _hashCode += getCONDITION_TYPE().hashCode();
        }
        if (getCONDITION_PURPOSE() != null) {
            _hashCode += getCONDITION_PURPOSE().hashCode();
        }
        if (getDATE_FROM_CONDITION() != null) {
            _hashCode += getDATE_FROM_CONDITION().hashCode();
        }
        if (getDATE_UP_TO_CONDITION() != null) {
            _hashCode += getDATE_UP_TO_CONDITION().hashCode();
        }
        if (getCURRENCY_CONDITION() != null) {
            _hashCode += getCURRENCY_CONDITION().hashCode();
        }
        if (getNO_POSTING_TERM() != null) {
            _hashCode += getNO_POSTING_TERM().hashCode();
        }
        if (getNO_FREQUENCY_TERM() != null) {
            _hashCode += getNO_FREQUENCY_TERM().hashCode();
        }
        if (getNO_ORGANIZATIONAL_TERM() != null) {
            _hashCode += getNO_ORGANIZATIONAL_TERM().hashCode();
        }
        if (getCOST_CENTER() != null) {
            _hashCode += getCOST_CENTER().hashCode();
        }
        if (getPROFIT_CENTER() != null) {
            _hashCode += getPROFIT_CENTER().hashCode();
        }
        if (getCALCULATION_FORMULA() != null) {
            _hashCode += getCALCULATION_FORMULA().hashCode();
        }
        if (getCURRENCY_UNIT_PRICE() != null) {
            _hashCode += getCURRENCY_UNIT_PRICE().hashCode();
        }
        if (getDISTRIBUTION_FORMULA() != null) {
            _hashCode += getDISTRIBUTION_FORMULA().hashCode();
        }
        if (getCONDITIONS_EXTERNAL_PURPOSE() != null) {
            _hashCode += getCONDITIONS_EXTERNAL_PURPOSE().hashCode();
        }
        if (getCONDITION_ONE_TIME1() != null) {
            _hashCode += getCONDITION_ONE_TIME1().hashCode();
        }
        if (getSTATISTICAL_INFO_CONDITION1() != null) {
            _hashCode += getSTATISTICAL_INFO_CONDITION1().hashCode();
        }
        if (getPOSTING_START_DATE_CONDITION() != null) {
            _hashCode += getPOSTING_START_DATE_CONDITION().hashCode();
        }
        if (getNO_OF_WHT_TERM() != null) {
            _hashCode += getNO_OF_WHT_TERM().hashCode();
        }
        if (getDIFFERENT_DUE_DATE_ONE_TIME() != null) {
            _hashCode += getDIFFERENT_DUE_DATE_ONE_TIME().hashCode();
        }
        if (getGRADING_TERM_IN_MONTHS() != null) {
            _hashCode += getGRADING_TERM_IN_MONTHS().hashCode();
        }
        if (getGRADING_INTERVAL_MONTHS() != null) {
            _hashCode += getGRADING_INTERVAL_MONTHS().hashCode();
        }
        if (getGRADING_PERCENT_INCREASE() != null) {
            _hashCode += getGRADING_PERCENT_INCREASE().hashCode();
        }
        if (getGRADING_ABSOLUTE_INCREASE() != null) {
            _hashCode += getGRADING_ABSOLUTE_INCREASE().hashCode();
        }
        if (getCONTRACT_STATUS() != null) {
            _hashCode += getCONTRACT_STATUS().hashCode();
        }
        if (getVALUATION_RULE() != null) {
            _hashCode += getVALUATION_RULE().hashCode();
        }
        if (getOBJECT_ID() != null) {
            _hashCode += getOBJECT_ID().hashCode();
        }
        if (getOBJECT_TYPE() != null) {
            _hashCode += getOBJECT_TYPE().hashCode();
        }
        if (getOBJECT_VALID_FROM() != null) {
            _hashCode += getOBJECT_VALID_FROM().hashCode();
        }
        if (getOBJECT_VALID_TO() != null) {
            _hashCode += getOBJECT_VALID_TO().hashCode();
        }
        if (getSTART_DATE_OF_CONSIDERATION() != null) {
            _hashCode += getSTART_DATE_OF_CONSIDERATION().hashCode();
        }
        if (getFIRST_POSTING_FROM1() != null) {
            _hashCode += getFIRST_POSTING_FROM1().hashCode();
        }
        if (getCLASSIFICATION() != null) {
            _hashCode += getCLASSIFICATION().hashCode();
        }
        if (getINTEREST_RATE() != null) {
            _hashCode += getINTEREST_RATE().hashCode();
        }
        if (getFREQUENCY_TERM() != null) {
            _hashCode += getFREQUENCY_TERM().hashCode();
        }
        if (getDISTRIBUT_FORMULA() != null) {
            _hashCode += getDISTRIBUT_FORMULA().hashCode();
        }
        if (getDISTRIB_FORMULA_PARAMETER() != null) {
            _hashCode += getDISTRIB_FORMULA_PARAMETER().hashCode();
        }
        if (getPROBABLE_END() != null) {
            _hashCode += getPROBABLE_END().hashCode();
        }
        if (getEND_OF_USAGE_ROU() != null) {
            _hashCode += getEND_OF_USAGE_ROU().hashCode();
        }
        if (getVALUATION_STATUS() != null) {
            _hashCode += getVALUATION_STATUS().hashCode();
        }
        if (getVALUATION_BEHAVIOR() != null) {
            _hashCode += getVALUATION_BEHAVIOR().hashCode();
        }
        if (getCOMPANY_CODE() != null) {
            _hashCode += getCOMPANY_CODE().hashCode();
        }
        if (getASSET() != null) {
            _hashCode += getASSET().hashCode();
        }
        if (getSUBNO() != null) {
            _hashCode += getSUBNO().hashCode();
        }
        if (getOBJECT_DESCRIPTION() != null) {
            _hashCode += getOBJECT_DESCRIPTION().hashCode();
        }
        if (getACCTASGOBJTYPE() != null) {
            _hashCode += getACCTASGOBJTYPE().hashCode();
        }
        if (getABSOLUTE_START() != null) {
            _hashCode += getABSOLUTE_START().hashCode();
        }
        if (getABSOLUTE_END() != null) {
            _hashCode += getABSOLUTE_END().hashCode();
        }
        if (getCOND_VAL_PROPERTY() != null) {
            _hashCode += getCOND_VAL_PROPERTY().hashCode();
        }
        if (getCOND_CONSIDERATION() != null) {
            _hashCode += getCOND_CONSIDERATION().hashCode();
        }
        if (getCONSIDER_CONDITION() != null) {
            _hashCode += getCONSIDER_CONDITION().hashCode();
        }
        if (getPERCENTAGE() != null) {
            _hashCode += getPERCENTAGE().hashCode();
        }
        if (getABSOLUTE_SHARE() != null) {
            _hashCode += getABSOLUTE_SHARE().hashCode();
        }
        if (getCURRENCY() != null) {
            _hashCode += getCURRENCY().hashCode();
        }
        if (getCONDITION_PURPOSE1() != null) {
            _hashCode += getCONDITION_PURPOSE1().hashCode();
        }
        if (getUNIT_PRICE1() != null) {
            _hashCode += getUNIT_PRICE1().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZREIF_S_SEM_CONTRACT_CHANGE_IN.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZREIF_S_SEM_CONTRACT_CHANGE_IN"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FILENAME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FILENAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("REFERENCE_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "REFERENCE_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ACTIVITY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ACTIVITY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COMP_CODE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COMP_CODE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTRACT_NO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTRACT_NO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COMPANY_CODE_MAIN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COMPANY_CODE_MAIN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MAIN_CONTRACT_NO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MAIN_CONTRACT_NO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OLD_CONTRACT_NO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OLD_CONTRACT_NO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTRACT_TYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTRACT_TYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OBJECT_DESC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OBJECT_DESC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTRACT_NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTRACT_NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTRACT_CONCLUSION_DATE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTRACT_CONCLUSION_DATE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATE_CONTRACT_START");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DATE_CONTRACT_START"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATE_FIRST_CONTRACT_END");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DATE_FIRST_CONTRACT_END"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AUTHORIZATION_GROUP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AUTHORIZATION_GROUP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("INDUSTRY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "INDUSTRY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PERSON_RESPONSIBLE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PERSON_RESPONSIBLE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CASH_FLOW_STARTING_ON");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CASH_FLOW_STARTING_ON"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FIRST_POSTING_FROM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FIRST_POSTING_FROM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CURRENCY_FOR_CONTRACT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CURRENCY_FOR_CONTRACT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TYPE_OF_RENEWAL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TYPE_OF_RENEWAL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RENEWAL_RULE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RENEWAL_RULE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEQUENCE_NO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SEQUENCE_NO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NO_OF_RENEWALS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NO_OF_RENEWALS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTRACT_RENEWED_YEARS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTRACT_RENEWED_YEARS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTRACT_RENEWED_MONTHS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTRACT_RENEWED_MONTHS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTRACT_RENEWED_DAYS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTRACT_RENEWED_DAYS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TYPE_OF_AUTOMATIC_RENEWAL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TYPE_OF_AUTOMATIC_RENEWAL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RENEWAL_EXECUTION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RENEWAL_EXECUTION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TERM_NO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TERM_NO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PAYMENT_METHOD");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PAYMENT_METHOD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PMT_METHSUPL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PMT_METHSUPL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("INDIVID_SET");
        elemField.setXmlName(new javax.xml.namespace.QName("", "INDIVID_SET"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PAYMENT_BLOCK_KEY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PAYMENT_BLOCK_KEY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TERMS_OF_PAYMENT_KEY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TERMS_OF_PAYMENT_KEY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("KEY_FOR_HOUSE_BANK");
        elemField.setXmlName(new javax.xml.namespace.QName("", "KEY_FOR_HOUSE_BANK"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BANK_DETAILS_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BANK_DETAILS_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NOTE_TO_PAYEE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NOTE_TO_PAYEE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DUNNING_AREA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DUNNING_AREA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DUNNING_BLOCK");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DUNNING_BLOCK"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ACCOUNT_DETERMINATION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ACCOUNT_DETERMINATION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TAX_TYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TAX_TYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TAX_GROUP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TAX_GROUP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BUSINESS_PARTNER_NO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BUSINESS_PARTNER_NO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TERM_NO1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TERM_NO1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FREQUENCY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FREQUENCY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FREQUENCY_UNIT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FREQUENCY_UNIT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STARTING_MONTH");
        elemField.setXmlName(new javax.xml.namespace.QName("", "STARTING_MONTH"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PAYMENT_FORM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PAYMENT_FORM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PRORATED");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PRORATED"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CALCULATE_METHOD");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CALCULATE_METHOD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FACTORY_CALENDAR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FACTORY_CALENDAR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PARTNER_DAT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PARTNER_DAT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ROLE_TYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ROLE_TYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATE_START_RELATIONSHIP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DATE_START_RELATIONSHIP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATE_END_RELATIONSHIP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DATE_END_RELATIONSHIP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ADDRESS_TYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ADDRESS_TYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONDITION_SPLIT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONDITION_SPLIT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONDITION_TYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONDITION_TYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONDITION_PURPOSE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONDITION_PURPOSE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATE_FROM_CONDITION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DATE_FROM_CONDITION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATE_UP_TO_CONDITION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DATE_UP_TO_CONDITION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CURRENCY_CONDITION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CURRENCY_CONDITION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NO_POSTING_TERM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NO_POSTING_TERM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NO_FREQUENCY_TERM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NO_FREQUENCY_TERM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NO_ORGANIZATIONAL_TERM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NO_ORGANIZATIONAL_TERM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COST_CENTER");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COST_CENTER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROFIT_CENTER");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PROFIT_CENTER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CALCULATION_FORMULA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CALCULATION_FORMULA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CURRENCY_UNIT_PRICE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CURRENCY_UNIT_PRICE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DISTRIBUTION_FORMULA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DISTRIBUTION_FORMULA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONDITIONS_EXTERNAL_PURPOSE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONDITIONS_EXTERNAL_PURPOSE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONDITION_ONE_TIME1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONDITION_ONE_TIME1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STATISTICAL_INFO_CONDITION1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "STATISTICAL_INFO_CONDITION1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("POSTING_START_DATE_CONDITION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "POSTING_START_DATE_CONDITION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NO_OF_WHT_TERM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NO_OF_WHT_TERM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DIFFERENT_DUE_DATE_ONE_TIME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DIFFERENT_DUE_DATE_ONE_TIME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GRADING_TERM_IN_MONTHS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GRADING_TERM_IN_MONTHS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GRADING_INTERVAL_MONTHS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GRADING_INTERVAL_MONTHS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GRADING_PERCENT_INCREASE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GRADING_PERCENT_INCREASE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GRADING_ABSOLUTE_INCREASE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GRADING_ABSOLUTE_INCREASE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTRACT_STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTRACT_STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VALUATION_RULE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VALUATION_RULE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OBJECT_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OBJECT_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OBJECT_TYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OBJECT_TYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OBJECT_VALID_FROM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OBJECT_VALID_FROM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OBJECT_VALID_TO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OBJECT_VALID_TO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("START_DATE_OF_CONSIDERATION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "START_DATE_OF_CONSIDERATION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FIRST_POSTING_FROM1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FIRST_POSTING_FROM1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CLASSIFICATION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CLASSIFICATION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("INTEREST_RATE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "INTEREST_RATE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FREQUENCY_TERM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FREQUENCY_TERM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DISTRIBUT_FORMULA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DISTRIBUT_FORMULA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DISTRIB_FORMULA_PARAMETER");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DISTRIB_FORMULA_PARAMETER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROBABLE_END");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PROBABLE_END"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("END_OF_USAGE_ROU");
        elemField.setXmlName(new javax.xml.namespace.QName("", "END_OF_USAGE_ROU"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VALUATION_STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VALUATION_STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VALUATION_BEHAVIOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VALUATION_BEHAVIOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COMPANY_CODE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COMPANY_CODE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ASSET");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ASSET"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SUBNO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SUBNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OBJECT_DESCRIPTION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OBJECT_DESCRIPTION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ACCTASGOBJTYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ACCTASGOBJTYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ABSOLUTE_START");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ABSOLUTE_START"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ABSOLUTE_END");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ABSOLUTE_END"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COND_VAL_PROPERTY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COND_VAL_PROPERTY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COND_CONSIDERATION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COND_CONSIDERATION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONSIDER_CONDITION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONSIDER_CONDITION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PERCENTAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PERCENTAGE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ABSOLUTE_SHARE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ABSOLUTE_SHARE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CURRENCY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CURRENCY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONDITION_PURPOSE1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONDITION_PURPOSE1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UNIT_PRICE1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UNIT_PRICE1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
