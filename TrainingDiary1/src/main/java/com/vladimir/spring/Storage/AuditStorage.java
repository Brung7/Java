package com.vladimir.spring.Storage;

import com.vladimir.spring.Models.Audit;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс аудита пользователя
 */
public class AuditStorage {
    /**
     * Map в которой хранится в качестве ключа пользователь, а в качестве значения объект класса Audit
     */
    private final Map<String, Audit> audits = new HashMap<>();

    /**
     * Метод добавляет аудит в Map
     * @param username
     * @param audit
     */
    public void addToAudit(String username, Audit audit){
        audits.put(username,audit);
    }

}
