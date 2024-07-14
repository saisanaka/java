-- Inserting 10 rows of dummy data for Question entity

INSERT INTO question (question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) 
VALUES 
('Which keyword is used to define a class in Java?', 'class', 'int', 'void', 'String', 'class', 'Easy', 'Java'),
('What is the output of 10 % 3 in Java?', '0', '1', '2', '3', '1', 'Medium', 'Java'),
('What is the default value of a local variable in Java?', '0', 'null', 'false', 'undefined', 'undefined', 'Easy', 'Java'),
('What is the use of finally block in Java exception handling?', 'To execute code in all cases', 'To execute code only when an exception occurs', 'To execute code only when no exception occurs', 'To skip exception handling', 'To execute code in all cases', 'Hard', 'Java'),
('Which collection class allows you to associate a key with a value in Java?', 'ArrayList', 'HashSet', 'HashMap', 'LinkedList', 'HashMap', 'Medium', 'Java'),
('Which data type is mutable in Python?', 'tuple', 'list', 'string', 'set', 'list', 'Medium', 'Python'),
('What is the output of 3 * 2 ** 3 in Python?', '24', '48', '12', '6', '24', 'Hard', 'Python'),
('What does the method append() do in Python lists?', 'Inserts an element at the specified index', 'Adds an element to the end of the list', 'Removes the last element from the list', 'Returns the length of the list', 'Adds an element to the end of the list', 'Easy', 'Python'),
('What is the output of the following Python code?\n\nx = [1, 2, 3]\nprint(x.pop())', '1', '2', '3', 'None of the above', '3', 'Easy', 'Python'),
('Which module in Python provides support for creating graphical user interfaces (GUIs)?', 'tkinter', 'numpy', 'pandas', 'matplotlib', 'tkinter', 'Medium', 'Python'),
('What is the output of the following C++ code?\n#include <iostream>\nusing namespace std;\nint main() {\n   int x = 5;\n   cout << x++ << endl;\n   return 0;\n}', '5', '6', '4', 'Error', '5', 'Medium', 'C++'),
('What is the correct syntax to allocate memory dynamically in C++?', 'int* ptr = new int;', 'int ptr = new int();', 'int* ptr = malloc(sizeof(int));', 'int ptr = malloc(sizeof(int*));', 'int* ptr = new int;', 'Hard', 'C++'),
('What does the keyword ''auto'' represent in C++11?', 'An automatic variable', 'An anonymous variable', 'A type placeholder', 'A constant variable', 'A type placeholder', 'Easy', 'C++'),
('What is the output of the following C++ code?\n#include <iostream>\nusing namespace std;\nint main() {\n   int x = 10;\n   int y = 5;\n   cout << x / y << endl;\n   return 0;\n}', '2', '2.0', '2.5', 'Error', '2', 'Medium', 'C++'),
('What is the correct way to declare a pointer to a function in C++?', 'int (*ptr)();', 'int ptr();', 'int ptr[]();', 'None of the above', 'int (*ptr)();', 'Hard', 'C++');
