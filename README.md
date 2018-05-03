# MongoDbIntegrationWithSpringBoot

The repository is intended to show how an embeded MongoDb which is configured and run with the help of SpringBoot. 
For achieving this, A simple Person entity is created, no annotation is needed for the entity because SpringData will be aware of the field id in Person class.

To run the embededed Mongo instance ,a Configuration class is created where  a mongotemplate bean is defined ,later on this mongotemplate will be injected into person repository.

Before running the application , sample person entities are created in run method of the commandlinerunner interface and those are persisted to mongodb.

As for repository, Person repository is created under repository package. This repo extends MongoRepository that is why no need to create an implementation class for simple crud operations, those impls will be created on the fly by spring.

