#! /bin/bash

# Install MacOS E2E environment
brew update
brew install jq
brew install curl
brew install docker
brew install node
brew install azure-cli
brew install carthage

# install openjdk11
brew install openjdk@11

# symlink for Java wrappers
sudo ln -sfn /usr/local/opt/openjdk@11/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-11.jdk

# if needed 1st in path
# echo 'export PATH="/usr/local/opt/openjdk@11/bin:$PATH"' >> ~/.zshrc

# set JAVA_HOME
export JAVA_HOME="$(/usr/libexec/java_home -v 11)"

echo 'export JAVA_HOME="$(/usr/libexec/java_home -v 11)"' >> ~/.bashrc
echo 'export JAVA_HOME="$(/usr/libexec/java_home -v 11)"' >> ~/.zshrc

brew install maven

# add temp keys
PUBKEY=""
PRIVKEY=""
SSH_FILE="./id_key"

echo "$PRIVKEY" > "$SSH_FILE"
echo "$PUBKEY" > "${SSH_FILE}.pub"

# launch SSH agent
eval "$(ssh-agent -s)"
ssh-add "$SSH_FILE"

# clone API tests project
git clone git@github.com:whitespace-software/APITestAutomation.git
cd APITestAutomation
git checkout dev

# run API tests
mvn clean test declaration