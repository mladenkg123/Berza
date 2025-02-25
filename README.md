# Stock Exchange gRPC Application

## Overview

This project implements a stock exchange system using gRPC for communication between client and server components. The application allows users to monitor stock prices, follow specific symbols, and execute trading operations in real-time.

## Features

- Real-time stock price monitoring
- Symbol following functionality
- Buy/Sell order execution
- Client ID generation
- Transaction logging
- TCP connection handling
- Company shares tracking

## Technology Stack

- Java 8+
- gRPC
- Protocol Buffers
- Maven
- Reactor Netty
- JANSI (for console coloring)

## Project Structure

The main components are defined in:

- Stock Exchange Service Proto (see `stockexchange.proto`)
- Stock Exchange Service Implementation (see `StockExchangeServiceImpl.java`)
- Stock Exchange Client (see `StockExchangeClient.java`)
- Stock Exchange Server (see `StockExchangeServer.java`)

## Setup

1. Ensure you have Java 8+ and Maven installed
2. Clone the repository
3. Run `mvn clean install` to build the project

## Dependencies

The project uses the following main dependencies (defined in pom.xml):

- gRPC (netty, protobuf, stub)
- Reactor Netty
- JANSI
- Apache Tomcat Annotations API

## Available Commands

The client supports the following commands:

- `/exit` - Close the application
- `/follow @symbol` - Follow specific stock symbols
- `/ask` - Request sell offers
- `/bid` - Request buy offers
- `/buy` - Execute buy order
- `/sell` - Execute sell order
- `/submit` - Submit an order
- `/get` - Get stock information

## Initial Stock Data

The application comes pre-loaded with initial stock data for several companies including:

- T-Mobile US Inc. (TMUS)
- General Electric Company (GE)
- Tesla Inc. (TSLA)
- Apple Inc. (AAPL)
- And more...

## Building and Running

### Server

1. Build the project using Maven
2. Run the StockExchangeServer class
3. Server will start on port 8090

### Client

1. Build the project using Maven
2. Run the StockExchangeClient class
3. Follow the on-screen prompts to interact with the system

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

## License

This project is part of RAF PDS (as seen in the package naming).
