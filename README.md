# EBook-Project

## RoomDatabase 

## 1. Data Binding With TextViews
      The Data Binding Library is a support library that allows 
      you to bind UI components in your layouts to data sources in your app
      using a declarative format rather than programmatically.

      Layouts are often defined in activities with code that calls UI framework methods.
      For example, the code below calls findViewById()
      to find a TextView widget and bind it to the userName property of the viewModel variable

## 2. Data Binding For Event Listeners
      n previous articles, I wrote about how to eliminate findViewById from
      Android applications and in some cases eliminate the need for View IDs altogether. 
      One thing I didn’t explicitly mention in those articles is how to handle event listeners,
      such as View’s OnClickListener and TextView’s TextWatcher.
      
      Android Data Binding provides three mechanisms to set an event listener
      in the layout file and you can choose whichever is most convenient for you.
      Unlike the standard Android onClick attribute,
      none of the event data binding mechanisms use reflection, so performance
      is good whichever mechanism you choose.
      
## Respository 

![Image description](https://miro.medium.com/max/981/1*5kNXJ7aFSGJvuh4r4egpTg.png)

### Why the Repository Pattern ?

* decouples the application from the data sources

* provides data from multiple sources (DB, API) without clients being concerned about this

* isolates the data layer

* single place, centralized, consistent access to data

* testable business logic via Unit Tests

* easily add new sources

So our repository now talks to the API data source and with the cache data source.
We would now want to add another source for our data, a database source.

## Mvvm 

## Why do we need these patterns?
Adding everything in a Single Activity or Fragment would lead to problems in testing and refactoring the code. Hence, the use of separation of code and clean architecture is recommended.

## Android MVVM

MVVM stands for Model, View, ViewModel.

* Model
      This holds the data of the application. It cannot directly talk to the View. Generally, it’s recommended to expose the data to the ViewModel through Observables.

* View
      It represents the UI of the application devoid of any Application Logic. It observes the ViewModel.

* ViewModel
      It acts as a link between the Model and the View. It’s responsible for transforming the data from the Model. It provides data streams to the View. It also uses hooks or callbacks to update the View. It’ll ask for the data from the Model.
      
The following flow illustrates the core MVVM Pattern.

![Image description](https://cdn.journaldev.com/wp-content/uploads/2018/04/android-mvvm-pattern.png)

## DataBinding 

Android DataBinding provides a way to tie the UI with business logic allowing the UI values to update automatically without manual intervention. This reduces lot of boilerplate code in your business logic that you usually write to sync the UI when new data is available. DataBinding is one of the android architecture components suggested by android.

In this article we are going to learn the basics of DataBinding and in the next article, a simple profile screen is built using the RecyclerView with DataBinding.

![Image description](https://miro.medium.com/max/3104/1*iJqgAGizxhw2BWF__wXEjA.png)

## AsynTask 

AsyncTask enables proper and easy use of the UI thread.
This class allows you to perform background operations and publish results on the UI 
thread without having to manipulate threads and/or handlers.

AsyncTask is designed to be a helper class around Thread and Handler and does not constitute a generic threading framework.
AsyncTasks should ideally be used for short operations (a few seconds at the most.)
If you need to keep threads running for long periods of time, it is highly recommended 
you use the various APIs provided by the java.util.concurrent package such as Executor, ThreadPoolExecutor and FutureTask.

An asynchronous task is defined by a computation that runs on a background thread and whose result is published on the UI thread.
An asynchronous task is defined by 3 generic types, called Params,
Progress and Result, and 4 steps, called onPreExecute, doInBackground, onProgressUpdate and onPostExecute.

## Executors 

An object that executes submitted Runnable tasks. This interface provides 
a way of decoupling task submission from the mechanics of how each task will be run, including details of thread use, scheduling, 
etc. An Executor is normally used instead of explicitly creating threads. For example,
rather than invoking new Thread(new RunnableTask()).start() for each of a set of tasks.

## DiffUtil

DiffUtil is a utility class that can calculate the difference between two 
lists and output a list of update operations that converts the first list into the second one.

It can be used to calculate updates for a RecyclerView Adapter. See ListAdapter and AsyncListDiffer
which can compute diffs using DiffUtil on a background thread.

DiffUtil uses Eugene W. Myers's difference algorithm to calculate the minimal number of updates to
convert one list into another. Myers's algorithm does not handle items that are moved so DiffUtil 
runs a second pass on the result to detect items that were moved.

If the lists are large, this operation may take significant time so you are advised to run
this on a background thread, get the DiffUtil.DiffResult then apply it on the RecyclerView on the main thread.

This algorithm is optimized for space and uses O(N) space to find the minimal number of 
addition and removal operations between the two lists. It has O(N + D^2) expected time 
performance where D is the length of the edit script.

If move detection is enabled, it takes an additional O(N^2) time where N is the total 
number of added and removed items. If your lists are already sorted by the same constraint (e.g. a created timestamp 
for a list of posts), 
you can disable move detection to improve performance.

The actual runtime of the algorithm significantly depends on the number of changes in the list and the cost
of your comparison methods. Below are some average run times for reference: 
(The test list is composed of random UUID Strings and the tests are run on Nexus 5X with M)

* 100 items and 10 modifications: avg: 0.39 ms, median: 0.35 ms

* 100 items and 100 modifications: 3.82 ms, median: 3.75 ms

* 100 items and 100 modifications without moves: 2.09 ms, median: 2.06 ms

* 1000 items and 50 modifications: avg: 4.67 ms, median: 4.59 ms

* 1000 items and 50 modifications without moves: avg: 3.59 ms, median: 3.50 ms

* 1000 items and 200 modifications: 27.07 ms, median: 26.92 ms

* 1000 items and 200 modifications without moves: 13.54 ms, median: 13.36 ms

Due to implementation constraints, the max size of the list can be 2^26.


