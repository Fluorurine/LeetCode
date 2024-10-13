Use go vendor (when you publish your go project)

# About The Project

This is the project to slove LeetCode solution in Go (or more platform in the future).

There is no correct project structure for go. It all depend on use case. As this simple write and test project, I recommend flat structure:

```text
.
├── cmd
│   └── main.go (main entry package - for future developent)
├── solution
│   └── ... (group of problems solutions function)
├── solutiontest (contain test case for solutions)
│   └── ...
├─── go.mod (contain package manager file (every file will be import from the directory contain go.mod))
└─ ...
```

- Every file in go is a module. The module hosting location is where the go.mod file is, every other file in subdirectory can be consider a package
- When import other module you must host that module on internet or replace the module with local module in go mod or use go.work file.
- Package name should be the same name as directory.
- Test file should be seperate from module to test.

💡 **Noitce:** All command run from our **root directory** ( . directory)

# Getting Started

## Prerequisites

- Go installed local, you usually want latest version. (As we only use the built-ins for testing and formatting). Go 1.11+ (for module to work)
- Go extension in VSCode (Optional)

Note:

Go module are install in the GOPATH (usually where your GO bin is) globally.
Go.mod freeze specific Go version and dependancy (to vendor folder) when publish. (Go module usually work for old Go version unless marked as incompatible)

## Installation

Clone the project, cd into LeetCodeGo.
Go version and all it dependency in one module can be change by only use one line in go.mod file.
Optional: When starting project you run:

```bash
go mod init <module_name>
```

Install testify for more readable test.

```bash
go get github.com/stretchr/testify
# (for go to clean and download the dependency then update go.sum file)
go mod tidy
```

## Usage & Explain

### Run the main class and test

---

Basically, you run the solution function through test.

You write the func for a problem with annotations in it corresponding package => format it => import that func in `solutiontest` test file.
Naming convention:

- Use CamelCase for naming variables and functions. Avoid underscores or mixedCaps in package names; prefer lower case single-word names 24.
- For exported names (accessible outside the package), capitalize the first letter (e.g., MyFunction).

Test-naming convention:
Test files should end with \_test.go. For example, if your main file is main.go, create a test file named main_test.go.
Each test function must start with Test and take a pointer to testing.T as an argument. Here’s an example:

```go
func TestAdd(t *testing.T) {
    got := Add(1, 2)
    want := 3

    if got != want {
        t.Errorf("Add(1, 2) = %d; want %d", got, want)
    }
}
```

Then test using: (-v flag for verbose result - you know the pattern)

```bash
go test ./solutiontest/... -v
```

### Linting

Go have built in formater go-fmt (But configure vscode extension go)

Here are some useful flags you can use with gofmt:
-l: List files whose formatting differs from gofmt.
-w: Write the result back to the original file.
-s: Simplify code where possible.

```bash
go -w  fmt path/to/your/package

go fmt ./...
```

In VSCode, go fmt can be used on save with Setting>Go>format tool use `go-fmt`
