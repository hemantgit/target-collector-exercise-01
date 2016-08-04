package com.backbase.training.targeting.restcollector;

import com.backbase.portal.targeting.connectorframework.content.contexts.GeoLocationCollector;
import com.backbase.portal.targeting.connectorframework.content.contexts.SessionContextCollector;
import com.backbase.portal.targeting.connectorframework.content.contexts.definition.ContextCollector;
import com.backbase.portal.targeting.connectorframework.content.contexts.definition.PossibleValue;
import com.backbase.portal.targeting.connectorframework.content.contexts.definition.ResultEntries;
import com.backbase.portal.targeting.connectorframework.content.contexts.definition.SelectorDefinition;
import com.backbase.portal.targeting.rulesengine.type.RuleEngineTypes;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CustomerInformationCollector extends ContextCollector {

    private static final Logger logger = LoggerFactory.getLogger(CustomerInformationCollector.class);
    private static final String CLASSE = "Classification";
    private static final String INCOME = "Annual Income";

    public CustomerInformationCollector() {
        super("CustomerInfoCollector",
                "Collects information about the logged-in customer",
                "$(contextRoot)/static/targeting/icon/age_collector.png",
                "Customer Information");
    }

    @Override
    public List<SelectorDefinition> defineSelectors(String portal, Map<String, String> properties) {
        List<SelectorDefinition> selectorDefinitions = new ArrayList<SelectorDefinition>();

        SelectorDefinition categoryDefinition = new SelectorDefinition(CLASSE, RuleEngineTypes.ENUM, "Class");
        categoryDefinition.setDescription("Category of the customer");
        categoryDefinition.addPossibleValues(new PossibleValue[]{new PossibleValue("Standard"), new PossibleValue("Gold"), new PossibleValue("Premium")});
        categoryDefinition.setDefaultValue("Standard");
        selectorDefinitions.add(categoryDefinition);

        SelectorDefinition annualIncomeDefinition = new SelectorDefinition(INCOME, RuleEngineTypes.INTEGER, "Income");
        annualIncomeDefinition.setDescription("Annual Income");
        annualIncomeDefinition.setMin(0);
        annualIncomeDefinition.setMax(1000000);
        selectorDefinitions.add(annualIncomeDefinition);

        return selectorDefinitions;
    }

    @Override
    public ResultEntries executeTask(Map<String, String> requestMap, ResultEntries resultEntries) {

        //get the username of the currently logged-in user
        String userName = requestMap.get("session.authentication.username");

        CustomerInfo info = CustomerInfoProvider.getInstance().getCustomerInfo(userName);

        if(info != null) {
            resultEntries.addSelectorEntry(CLASSE, info.getCustomerClass());
            resultEntries.addSelectorEntry(INCOME,Integer.toString(new Double(info.getAnnualIncome()).intValue()));
            logger.debug("customer: " + userName + " class: " + info.getCustomerClass() + " income: " + info.getAnnualIncome());

        }
        return resultEntries;
    }


}