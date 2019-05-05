BitcoinPriceMonitorSpring
=============================

A simple RESTful service shows important Bitcoin information only. You can see a few Bitcoin information on this web app. The purpose of this project is to implement RESTful services with MVC on Spring Framework.

There is no database in this project. The data source is the real-time Bitcoin information provided by Bitstamp.

Introduction
------------

This app is based on Bitstamp API, so you can find the same Bitcoin information on Bitstamp website (https://www.bitstamp.net/).

You can find the following services and check out the JSON responses on the screenshots below.

History function
---------------

1. Show all transactions history in the past one hour
2. Show transactions having the highest price in the past one hour based on _topId_ parameter

Bids function
---------------

1. Show all bids
2. Show recent bids based on _recentId_ parameter

Asks function
---------------

1. Show all asks
2. Show recent asks based on _recentId_ parameter

Screenshots
---------------

Please see below to check out the screenshots!

<p float="left">
  <img src="/screenshots/history.png?raw=true">
  <img src="/screenshots/history_and_topId.png?raw=true">
  <img src="/screenshots/bids.png?raw=true">
  <img src="/screenshots/bids_and_recentId.png?raw=true">
  <img src="/screenshots/asks.png?raw=true">
  <img src="/screenshots/asks_and_recentId.png?raw=true">
</p>
