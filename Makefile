SONAR_SCANNER ?= sonar-scanner

sources = repro/Apple.java repro/Fruit.java repro/Repro.java
classes = repro/Apple.class repro/Apple$$Builder.class repro/Fruit.class repro/Fruit$$Builder.class repro/Repro.class

all: success

success: repro.jar
	$(SONAR_SCANNER) --debug
	touch success

repro.jar: $(classes)
	rm -f $@
	jar cvf $@ repro/*.class

%.class: %.java
	javac $<

repro/Fruit.class repro/Fruit$$Builder.class: repro/Fruit.java
repro/Apple.class repro/Apple$$Builder.class: repro/Apple.java repro/Fruit.class repro/Fruit$$Builder.class
repro/Repro.class: repro/Repro.java repro/Apple.class repro/Apple$$Builder.class repro/Fruit.class repro/Fruit$$Builder.class

clean:
	rm -f repro.jar repro/*.class success

.PHONY: clean
