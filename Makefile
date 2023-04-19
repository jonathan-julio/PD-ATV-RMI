include .env.example

build:
	./mvnw package -f pom.xml

run: run-server run-client

run-server: 
	@nohup java -jar server/target/server-0.1-jar-with-dependencies.jar

run-client:
	java -jar server/target/client-0.1-jar-with-dependencies.jar

tmux: 
	tmux kill-session -t hospital || sleep 2; tmux new -s hospital -d
	# tmux new-window -t hospital -n library-1 'java -jar server/target/server-0.1-jar-with-dependencies.jar'
	tmux send-keys -t hospital 'java -jar server/target/server-0.1-jar-with-dependencies.jar' Enter
	tmux split-window -h -t hospital
	tmux send-keys -t hospital:0.1 'java -jar client/target/client-0.1-jar-with-dependencies.jar' Enter
	tmux send-keys -t hospital:0.1 'clear' Enter
	tmux attach-session -t hospital

tmux-kill:
	tmux kill-session -t hospital

config:
	@echo PORT=${PORT}


