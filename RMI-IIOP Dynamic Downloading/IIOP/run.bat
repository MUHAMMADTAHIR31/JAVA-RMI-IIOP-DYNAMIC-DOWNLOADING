set path=C:\Program Files\Java\jdk1.8.0_291\bin
javac *.java
rmic -iiop HelloImpl
pause
#javac -d . -classpath . HelloImpl.java
#javac -d . -classpath . HelloInterface.java
