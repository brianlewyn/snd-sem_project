FROM amazoncorretto:19-alpine-jdk
ENV USER='brianlewyn'

# Install packages
RUN apk add --no-cache bash curl neofetch git tree

# Git
RUN git config --global user.name $USER && \
git config --global user.email $USER@gmail.com && \
git config --global init.defaultBranch main && \
git config --global core.pager cat

# Bash
RUN bash -c "$(curl -fsSL https://raw.githubusercontent.com/ohmybash/oh-my-bash/master/tools/install.sh)"
ARG USERNAME="\"\${_omb_prompt_white}${USER}\${_omb_prompt_reset_color}\""
RUN cd ~/.oh-my-bash/themes/rr/ \
&& sed -i "18s/.*/  local user_name=${USERNAME}/" rr.theme.sh \
&& sed -i '27s/.*/  PS1="${user_name} ${arrow} ${base_directory} "/' rr.theme.sh \
&& sed -i '36s/.*/  PS1+="\\n$ "\n}/' ~/.oh-my-bash/themes/rr/rr.theme.sh
RUN cd ~/.oh-my-bash/themes && mv rr ../ && rm -rf * && mv ../rr .
RUN sed -i '12s/.*/OSH_THEME="rr"/' ~/.bashrc && source ~/.bashrc

CMD [ "bash", "-l" ]

# System
# Reopen in Container
# Install vscode extension: Extension Pack for Java

# Java
# java -version
# javac *.java
# java Main
