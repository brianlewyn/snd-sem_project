FROM amazoncorretto:19-alpine-jdk
ENV USER='brianlewyn'

# Install packages
RUN apk --no-cache add bash curl neofetch git tree
RUN git config --global user.name $USER && \
git config --global user.email $USER@gmail.com && \
git config --global init.defaultBranch main

# Customize Bash Prompt
RUN bash -c "$(curl -fsSL https://raw.githubusercontent.com/ohmybash/oh-my-bash/master/tools/install.sh)"
ARG WHITE='${_omb_prompt_white}'
ARG RESET='${_omb_prompt_reset_color}'
ARG UNKNOW="${WHITE}${USER}${RESET}"
RUN sed -i "18s/.*/  local user_name="${UNKNOW}"/" ~/.oh-my-bash/themes/rr/rr.theme.sh
RUN sed -i '27s/.*/  PS1="${user_name} ${arrow} ${base_directory} "/' ~/.oh-my-bash/themes/rr/rr.theme.sh
RUN sed -i '36s/.*/  PS1+="\n$ "\n}/' ~/.oh-my-bash/themes/rr/rr.theme.sh 
RUN cd ~/.oh-my-bash/themes && mv rr ../ && rm -rf * && mv ../rr .
RUN sed -i '12s/.*/OSH_THEME="rr"/' ~/.bashrc
RUN source ~/.bashrc

CMD [ "bash", "-l" ]

# System
# Reopen in Container
# Install vscode extension: Extension Pack for Java

# Java
# java -version
# javac *.java
# java Main
