## How to set up with Python

### <span style="color: cyan;">Requirement</span>

---

- **Python 3.12** (Any Python 3 version can be used as this project only use basic syntax)
- **venv** for virtual enviroment (You doesn't need this if you install all libary globally)
- **pytest** : For testing the solution
- **blackformatter**: Linting and codeformmater stuff

### Setup

💡 **Noitce:** <span style="color: yellow;">Do those step at this 'LeetCodePython' directory</span>

#### <span style="color: cyan;">Create dev virtual enviroment and activate it (ignore these step if you using Python globally)</span>

---

```bash
pip install virtualenv
```

Notice: this module usually built-in in python3

Next, we use **venv** module to create `.venv` (or any name you prefer) dir which contain a **virtual copy of global python version** to seperate our development enviroment from global enviroment.

```bash
python3 -m venv .venv
```

This folder is ignore when commit, when you replicate this project on your system, please create another `.venv` folder in this directory for your own use.

#### <span style="color: cyan;">Acitivate virtual enviroment</span>

---

As Windows and Linux-like create different `.venv` directory structureL

**Window**

```bash
.venv\Scripts\activate
```

**Linux**

```bash
source .venv/bin/activate
```

To deactivate virtual enviroment, simply:

```bash
deactivate
```

#### <span style="color: cyan;">Project structure</span>

---

```ASCII
LeetCodePython/
├── .venv (For local virtual enviroment libary, module, ...)
├── src (Solution classes with function and annotations for each group of problems)
└── test (Import those Soulution class to perform test with pytest module)
```

#### <span style="color: cyan;">From new solution to test</span>

---

- Activate your virtual Python enviroment. (If you have)
- Install the Python package from requirement.txt (pytest) - you can always update to latest version:
  ```bash
  pip install -r requirements.txt
  ```
- Add new Solutions function (for a problems) to solutions class. (for following steps just see the file class to see how it work)
- Format with **_Python Black Formmater_**

  ```bash
  black .
  ```

- Add the test as the assert function in pytest. Few things in mind:

  - Test file must be starting with `test_` or ending with `_test.py` (See array_and_hash_problem.py and test_arrayandhash for reference)
  - There is toogle test to decide if a test file for running or not.

- Run pytest with `pytest` command at `LeetCodePython`. `pytest` automatically scan all apporiate test file within current directory.
