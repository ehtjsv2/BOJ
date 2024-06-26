-- 코드를 작
SELECT FF.ID ,M.FISH_NAME ,FF.LENGTH
FROM FISH_INFO AS FF
INNER JOIN FISH_NAME_INFO I
ON FF.FISH_TYPE = I.FISH_TYPE
RIGHT OUTER JOIN (
    SELECT N.FISH_NAME AS FISH_NAME, MAX(LENGTH) AS LENGTH
    FROM FISH_INFO F
    INNER JOIN FISH_NAME_INFO N
    ON F.FISH_TYPE = N.FISH_TYPE
    GROUP BY N.FISH_NAME
) AS M
ON FF.LENGTH = M.LENGTH AND I.FISH_NAME = M.FISH_NAME
ORDER BY FF.ID ASC;

