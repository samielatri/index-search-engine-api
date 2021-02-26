package com.indexing.service;

import com.indexing.util.SQLKeywords;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created bu PacLab
 * User: sami
 * */

public class QueryParser {

    protected static boolean validateQuery(String query) {
        query = query.toUpperCase(Locale.ROOT);
        // TODO validate the WHERE part and simplify expression (if possible)
        return !(query == null || query.isBlank() || !query.startsWith(SQLKeywords.SELECT) || !query.contains(SQLKeywords.FROM));
    }

    protected static boolean isWhereQuery(String query) {
        query = query.toUpperCase(Locale.ROOT);
        return query.contains(SQLKeywords.WHERE);
    }

    protected static String[] extractQueryColumns(String query) {
        Pattern pattern = Pattern.compile(SQLKeywords.SELECT + "(.*?)" + SQLKeywords.FROM, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(query);
        String columnString = null;
        while (matcher.find()) {
            columnString = matcher.group(1);
        }
        // TODO: handle possible NullPointerException
        return columnString.split(SQLKeywords.SEPARATOR);

    }

    public static Map<String, String> extractQueryWhereConditions(String query) {
        Map<String, String> conditions = new HashMap<>();
        Pattern pattern = Pattern.compile(SQLKeywords.WHERE + "(.*?)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(query);
        String conditionString = null;
        while (matcher.find()) {
            conditionString = matcher.group(1);
        }
        // TODO: handle possible NullPointerException
        conditionString.replace(SQLKeywords.AND.toLowerCase(), SQLKeywords.AND);
        String[] splitConditions = conditionString.split(SQLKeywords.AND);
        for (String condition : splitConditions) {
            String[] keyValueCondition = condition.split(SQLKeywords.EQUAL);
            conditions.put(keyValueCondition[0], keyValueCondition[1]);
        }
        return conditions;
    }
}