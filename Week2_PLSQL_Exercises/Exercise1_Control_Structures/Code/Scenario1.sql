DECLARE
CURSOR cust_cursor IS 
SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate 
FROM Customers c
JOIN Loans l ON c.CustomerID = l.CustomerID;

age NUMBER;
discount NUMBER := 0.01;
BEGIN
FOR c_record IN cust_cursor LOOP
age:= FLOOR(MONTHS_BETWEEN(SYSDATE, c_record.DOB)/12);

IF age>=60 THEN
UPDATE Loans SET InterestRate= InterestRate - discount 
WHERE LoanID = c_record.LoanID;
DBMS_OUTPUT.PUT_LINE('Applied 1% discount to ' ||c_record.CustomerID);
END IF;
END LOOP;
END;
