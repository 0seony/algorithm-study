## SQL 장바구니의 수
- `CARTS` 테이블은 결제된 장바구니의 정보를 담은 테이블
- `ID` : 장바구니 아이디
- `USER_ID` : 유저 아이디
- `PAYED_AT` : 결제 일
- `PRODUCT_COUNT` : 장바구니에 담긴 상품 수

```
상품 수가 10개 이상인 장바구니를 2개 이상 결제한 유저의 ID와
해당 유저가 결제한 상품 수가 10개 이상인 장바구니의 수를 조회하는 SQL문 작성
```

1. 서브쿼리를 이용

```SQL
SELECT USER_ID, COUNT(*) PAYED_COUNT
FROM(
SELECT * FROM CARTS
WHERE PRODUCT_COUNT>=10)
GROUP BY USER_ID
HAVING COUNT(*)>=2
ORDER BY PAYED_COUNT, USER_ID DESC;
```
맨 처음에 그냥 이렇게 썼는데.. 서브쿼리 쓸 이유가 전혀 없음..ㅎ

2. 그냥
```SQL
SELECT USER_ID, COUNT(*) PAYED_COUNT
FROM CARTS
WHERE PRODUCT_COUNT>=10
GROUP BY USER_ID
HAVING COUNT(*)>=2
ORDER BY PAYED_COUNT, USER_ID DESC;
```
진짜 왜 서브쿼리로 풀었지;;
