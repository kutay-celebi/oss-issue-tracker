# stage1 - build react app first

#FROM node:12.16.1-alpine3.9 as build
#WORKDIR /app
#ENV PATH /app/node_modules/.bin:$PATH
#COPY ../package.json /app/
#RUN npm --silent
#COPY .. /app
#RUN npm build

FROM node:10-alpine as builder
# install and cache app dependencies
COPY package.json package-lock.json ./
RUN npm install && mkdir /react-frontend && mv ./node_modules ./react-frontend
WORKDIR /react-frontend
COPY . .
RUN npm run build

# stage 2 - build the final image and copy the react build files
FROM nginx:1.17.8-alpine
COPY --from=builder /react-frontend/build /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY nginx.conf /etc/nginx/conf.d
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]