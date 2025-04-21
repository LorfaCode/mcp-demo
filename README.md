# MCP Demo - Cryptocurrency OHLC Data Service

This Spring Boot application demonstrates the integration of the Kraken cryptocurrency exchange API with Spring AI's Model Context Protocol (MCP) server capabilities. It provides functionality to fetch OHLC (Open, High, Low, Close) data for various cryptocurrency pairs.

## Features

- Fetch OHLC data for any cryptocurrency pair available on Kraken.
- Configurable time intervals for OHLC data.
- Spring AI integration for enhanced API capabilities and connect to LLMs.

## Prerequisites

- Java 21 or higher
- Maven 3.6+x

## Building the Application

To build the application, run:

```bash
./mvnw clean install
```

## MCP Usage in Visual Studio Code.

To use MCP in Visual Studio Code, ensure that GitHub Copilot's agent mode is enabled. Follow these steps:

1. Enable agent mode in GitHub Copilot by navigating to the settings and toggling the "Enable Agent Mode" option.
2. Create an `mcp.json` file in the .vscode folder of your project. This file configures the MCP server and defines the context for your application.

Here is an example of an `mcp.json` file:

```json
{
  "servers": {
    "spring-ai-mcp-demo": {
      "command": "java",
      "args": [
        "-Dspring.ai.mcp.server.stdio=true",
        "-jar",
        "E:\\repos\\mcp-demo\\target\\mcp-demo-0.0.1-SNAPSHOT.jar"
      ]
    }
  }
}
```
- `servers`: Array of your MCP servers.
- `spring-ai-mcp-demo`: A conprenhensive name for your server. My example is just too generic, I know.
- `spring-ai-mcp-demo.command`: command to run it.
- `spring-ai-mcp-demo.args`: arguments for the command.x

Once configured, you can use MCP features directly in Visual Studio Code to interact with the application and leverage AI capabilities.

The OHLC data includes:

- Time
- Open price
- High price
- Low price
- Close price
- VWAP (Volume Weighted Average Price)
- Volume

## Technology Stack

- Spring Boot 3.4.4
- Spring AI (1.0.0-M7)
- Spring Web
- JUnit for testing

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/lorfacode/mcp/
│   │       ├── domain/         # Domain models
│   │       ├── dto/           # Data Transfer Objects
│   │       └── service/       # Business logic
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/lorfacode/mcp/
            └── McpDemoApplicationTests.java
```

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Contributing

[Add contribution guidelines here]
