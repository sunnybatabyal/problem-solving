/*
Enter your query here.
*/
SELECT d.NAME,
    COUNT(s.ID) AS COUNT_OF_STUDENTS_IN_THE_DEPARTMENT
    FROM DEPARTMENT d
        LEFT OUTER JOIN STUDENT s
            ON d.id = s.DEPT_ID
GROUP BY d.NAME
ORDER BY COUNT_OF_STUDENTS_IN_THE_DEPARTMENT DESC , d.NAME;