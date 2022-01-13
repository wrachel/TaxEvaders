 {% include navigation.html %}
# TaxEvaders README:  

### GitHub Contributors: Bryant Jin, Rachel Wei, Harry Li, Kevin Do
### Scrum Board: [https://github.com/wrachel/TaxEvaders/projects/1](https://github.com/wrachel/TaxEvaders/projects/1)

### Contributors links:

| Name               | Issues  | Scrum Board  |  Commits  | 
| ------------------ | ------- | ------------ | --------- | 
| Bryant Jin ([HexaDrakon](https://github.com/HexaDrakon))        | [Issues](https://github.com/wrachel/TaxEvaders/issues?q=assignee%3Ahexadrakon) | [Scrum Board](https://github.com/wrachel/TaxEvaders/projects/1?card_filter_query=assignee%3Ahexadrakon) | [Commits](https://github.com/wrachel/TaxEvaders/commits?author=HexaDrakon)  | 
| Rachel Wei ([wrachel](https://github.com/wrachel)) | [Issues](https://github.com/wrachel/TaxEvaders/issues?q=assignee%3Awrachel) | [Scrum Board](https://github.com/wrachel/TaxEvaders/projects/1?card_filter_query=assignee%3Awrachel) | [Commits](https://github.com/wrachel/TaxEvaders/commits?author=wrachel)  | 
| Harry Li ([wiz124](https://github.com/wiz124)) | [Issues](https://github.com/wrachel/TaxEvaders/issues?q=assignee%3Awiz124) | [Scrum Board](https://github.com/wrachel/TaxEvaders/projects/1?card_filter_query=assignee%3Awiz124) | [Commits](https://github.com/wrachel/TaxEvaders/commits?author=wiz124)  | 
| Kevin Do ([kevin-dough](https://github.com/kevin-dough)) | [Issues](https://github.com/wrachel/TaxEvaders/issues?q=assignee%3Akevin-dough) | [Scrum Board](https://github.com/wrachel/TaxEvaders/projects/1?card_filter_query=assignee%3Akevin-dough) | [Commits](https://github.com/wrachel/TaxEvaders/commits?author=kevin-dough)  | 

| Name               | Issues  | Scrum Board  |  Commits  | 
| ------------------ | ------- | ------------ | --------- |
{% for person in site.team_members %}
| {{person.name}} ([{{person.github}}](https://github.com/{{person.github}})) | [Issues](https://github.com/wrachel/TaxEvaders/issues?q=assignee%3A{{person.github}}) | [Scrum Board](https://github.com/wrachel/TaxEvaders/projects/1?card_filter_query=assignee%3A{{person.github}}) | [Commits](https://github.com/wrachel/TaxEvaders/commits?author={{person.github}})  |
{% endfor %}

## Ideation:
Honestly, we had no idea what our new project idea was, but Mr. Mortensen suggested a password tracker would be a good idea. So, our project is a password tracker. 

## Purpose:
Helping users better track their passwords. Using the same, easy to guess password (CyberPatriot1!) is not secure, but creating unique passwords for every program can be confusing to remember. Tax Evaders brings an easy-to-use password tracker to store all relevant info needed to access your favorite programs. 

## Usage:
Clone project and run the project locally. Deployed website coming soon.

## Running Locally:
### Requirements
* Thymeleaf
* jdk >8
#### How to run:
Navigate to and run [Main.java] file 
Go to localhost:8080 in a web browser to view our running website

## How to contribute: 
See [`contributing.md`](https://github.com/wrachel/TaxEvaders/blob/5e5f1cb281b90b64575ceae814b73877d11d5ec8/contributing.md).
NOTE: Although this may be obvious, please do not push any broken code. Thanks. 
lol

