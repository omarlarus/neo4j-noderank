CREATE INDEX ON :`PhoneNumber`(`id`);
CREATE INDEX ON :`Email`(`subject`);
CREATE CONSTRAINT ON (node:`User`) ASSERT node.`id` IS UNIQUE;
CREATE CONSTRAINT ON (node:`Repository`) ASSERT node.`id` IS UNIQUE;
CREATE CONSTRAINT ON (node:`File`) ASSERT node.`path` IS UNIQUE;
CREATE CONSTRAINT ON (node:`PullRequest`) ASSERT node.`id` IS UNIQUE;
CREATE CONSTRAINT ON (node:`EmailAddress`) ASSERT node.`_id` IS UNIQUE;
CREATE CONSTRAINT ON (node:`UNIQUE IMPORT LABEL`) ASSERT node.`UNIQUE IMPORT ID` IS UNIQUE;