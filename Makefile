all: build run

build:
	mvn package

run:
	java -jar target/swingy-1.0.jar console

rungui:
	java -jar target/swingy-1.0.jar gui

clean:
	mvn clean