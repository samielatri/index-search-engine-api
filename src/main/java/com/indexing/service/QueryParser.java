package com.indexing.service;

import com.indexing.model.QueryType;
import com.indexing.util.SQLKeywords;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created bu PacLab
 * User: PacLab
 */

public class QueryParser {

    protected static boolean validateQuery(String query) {
        query = query.toUpperCase(Locale.ROOT);
        boolean validWhereQuery = true;
        if (query.contains(SQLKeywords.WHERE)) {
            if (!query.contains(SQLKeywords.EQUAL)) {
                validWhereQuery = false;
            } else if (query.contains(SQLKeywords.WHERE) && query.trim().endsWith(SQLKeywords.WHERE)) {
                validWhereQuery = false;
            } else if (query.contains(SQLKeywords.AND) && query.contains(SQLKeywords.OR)) {
                System.err.println("Support for mixed (AND/OR) query is not supported yet");
                validWhereQuery = false;
            }
        }
        return validWhereQuery && !(query == null || query.isBlank() || !query.startsWith(SQLKeywords.SELECT) || !query.contains(SQLKeywords.FROM));
    }

    protected static boolean isWhereQuery(String query) {
        query = query.toUpperCase(Locale.ROOT);
        return query.contains(SQLKeywords.WHERE);
    }

    protected static String[] extractQueryColumns(String query) {
        String columnString = getStringWithRegex(query, SQLKeywords.SELECT + "(.*?)" + SQLKeywords.FROM);
        return columnString.split(SQLKeywords.SEPARATOR);
    }

    public static String[] extractQueryTables(String query) {
        String tables = getStringWithRegex(query, SQLKeywords.FROM + "(.*?)" + SQLKeywords.WHERE);
        return tables.split(SQLKeywords.SEPARATOR);
    }

    public static Map<String, String> extractQueryWhereConditions(String query, QueryType queryType) {
        query = query.replace(SQLKeywords.WHERE.toLowerCase(), SQLKeywords.WHERE);
        Map<String, String> conditions = new HashMap<>();
        String conditionStrings = query.substring(query.indexOf(SQLKeywords.WHERE) + SQLKeywords.WHERE.length() + 1);
        // TODO what about the case where the column name/value contain and/or strings ? eg: vend(or)ID
        conditionStrings = conditionStrings.replace(SQLKeywords.AND.toLowerCase(), SQLKeywords.AND).replace(SQLKeywords.OR.toLowerCase(), SQLKeywords.OR);
        String[] splitConditions;
        if (queryType == QueryType.AND) {
            splitConditions = conditionStrings.split(SQLKeywords.AND);
        } else {
            splitConditions = conditionStrings.split(SQLKeywords.OR);
        }
        for (String condition : splitConditions) {
            String[] keyValueCondition = condition.split(SQLKeywords.EQUAL);
            conditions.put(keyValueCondition[0].trim(), keyValueCondition[1].trim());
        }
        return conditions;
    }

    private static String getStringWithRegex(String query, String s) {
        Pattern pattern = Pattern.compile(s, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(query);
        String conditionString = null;
        while (matcher.find()) {
            conditionString = matcher.group(1);
        }
        return conditionString;
    }

    public static QueryType queryType(String query) {
        return query.contains(SQLKeywords.AND) || query.contains(SQLKeywords.AND.toLowerCase()) ? QueryType.AND : QueryType.OR;
    }
}