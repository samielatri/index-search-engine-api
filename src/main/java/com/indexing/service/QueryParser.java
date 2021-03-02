package com.indexing.service;

import com.indexing.util.SQLKeywords;

import java.sql.SQLWarning;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryParser {

    protected static boolean validateQuery(String query) {
        query = query.toUpperCase(Locale.ROOT);
        boolean validWhereQuery = true;
        if (query.contains(SQLKeywords.WHERE)) {
            if (!query.contains(SQLKeywords.EQUAL)) {
                validWhereQuery = false;
            } else if (query.contains(SQLKeywords.WHERE) && query.trim().endsWith(SQLKeywords.WHERE)) {
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

    public static Map<String, String> extractQueryWhereConditions(String query) {
        query = query.replace(SQLKeywords.WHERE.toLowerCase(), SQLKeywords.WHERE);
        Map<String, String> conditions = new HashMap<>();
        String conditionString = query.substring(query.indexOf(SQLKeywords.WHERE) + SQLKeywords.WHERE.length() + 1);
        conditionString = conditionString.replace(SQLKeywords.AND.toLowerCase(), SQLKeywords.AND);
        String[] splitConditions = conditionString.split(SQLKeywords.AND);
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
}