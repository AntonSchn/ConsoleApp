# Implement console application(mandatory)
- Read txt file and split it by lines
- Calculate statistic for each line and whole line: longest word(symbols between 2 spaces), shortest word, line length,
average word length,duplication of the words.
- Store line and file statistic into DB(With JDBC).
- Add unit tests.
------
# QUICK START
- In order to calculate statistics you need to create an object of class `FileData`. To display the collected statistics, call the method: `StatisticHelper.PrintFullStatistic`
- Example:
  ```java
   FileData temp = FileData.getFileDataByPath(path);
   StatisticHelper.PrintFullStatistic(temp);
  ```
------
 # ANNOTATION
  - SQLite is used to simplify job verification
------
   

