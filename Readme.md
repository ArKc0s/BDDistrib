# Distributed Database
## What we must do 

We must create 2 shard of our db to keep the data from France in one and the data from Great Britain in the other.
For each shard, we must add a replica set to keep the data safe.
We must also create a config server to keep the metadata of our db.
Finally, we have the mongos which is the router of our db.