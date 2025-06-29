CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
p_department IN VARCHAR2,
p_bonus_percent IN NUMBER) 
AS v_updated_count NUMBER := 0;
   v_department_exists NUMBER;
BEGIN
IF p_bonus_percent < 0 OR p_bonus_percent > 100 THEN
RAISE_APPLICATION_ERROR(-20001, 'Bonus percentage must be between 0 and 100');
END IF;
SELECT COUNT(*) INTO v_department_exists
FROM Employees
WHERE Department = p_department;
  
IF v_department_exists = 0 THEN
DBMS_OUTPUT.PUT_LINE('Department ' || p_department || ' not found');
RETURN;
END IF;
FOR emp_rec IN (
SELECT EmployeeID, Name, Salary
FROM Employees
WHERE Department = p_department) 
LOOP
UPDATE Employees
SET Salary = ROUND(Salary * (1 + (p_bonus_percent/100)), 2)
WHERE EmployeeID = emp_rec.EmployeeID;
v_updated_count := v_updated_count + 1;
DBMS_OUTPUT.PUT_LINE('Updated ' || emp_rec.Name || ': New salary $' || 
ROUND(emp_rec.Salary * (1 + (p_bonus_percent/100)), 2));
END LOOP;
COMMIT;
DBMS_OUTPUT.PUT_LINE('Applied ' || p_bonus_percent || '% bonus to ' ||   v_updated_count || ' employees in ' || p_department);
EXCEPTION
WHEN OTHERS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE('Error updating bonuses: ' || SQLERRM);
END UpdateEmployeeBonus;
/
BEGIN
UpdateEmployeeBonus('IT', 10);
END;
/