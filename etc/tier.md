## SQL 유저별 티어 정하기
- `GAME_USERS` 테이블은 xx런 게임 유저의 정보를 담고 있는 테이블
- `ID` : 유저의 아이디
- `DISTANCE` : 최고 기록(미터 단위)
- `TIME_SPENT` : 최고 기록 달성시 플레이한 시간
- `BEST_DATE` : 최고기록 경신 날짜

```
`티어`는 최고 기록을 기준으로 매겨지는 등급이다
모든 유저의 아이디와 티어를 나타내는 SQL문 작성
결과는 유저 아이디 기준으로 내림차순
```
### CASE-WHEN 표현식
```SQL
SELECT ID,CASE
WHEN DIS>=130000 THEN 'DIAMOND'
WHEN DIS>=100000 AND DIS<130000 THEN 'GOLD'
WHEN DIS>=50000 AND DIS<100000 THEN 'SILVER'
ELSE 'BRONZE' END AS TIER
FROM GAME_USERS
ORDER BY ID DESC;
```

#### IF문 방식
```SQL
CASE WHEN COL1>90 THEN 'A'
WHEN COL1>80 THEN 'B'
ELSE 'C'
END AS SCORE
```

#### SWITCH문 방식
```SQL
CASE COL1
WHEN 90 THEN 'A'
WHEN80 THEN 'B'
ELSE 'C'
END AS SCORE
```

- ELSE를 생략 후 만족하는 조건이 없으면 NULL 리턴
- 비교 연산자, 범위 연산자 사용 가능
- WHERE절에 사용 가능
