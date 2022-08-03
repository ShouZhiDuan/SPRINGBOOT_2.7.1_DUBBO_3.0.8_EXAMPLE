# Medusa
git status \
&& git pull \
&& mvn clean install \
&& docker build -t nvxhub.nvxclouds.net:9443/skadi/medusa-server:20220714-6 . \
&& docker push nvxhub.nvxclouds.net:9443/skadi/medusa-server:20220714-6


