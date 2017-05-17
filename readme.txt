-> requirements:
 gradle 3.1 or higher
 java 1.8
 define your own googlemaps.geocoder.client.key in google

-> run application project:
 bootRun task on main project

-> intelij changes for qdsl: (based on: http://bsideup.blogspot.com/2015/04/querydsl-with-gradle-and-idea.html)
Go to Preferences -> Build, Execution, Deployment -> Annotation Processors;
Check Enable annotation processing checkbox;
In "Store generated sources relative to:" select Module content root.
