class ConsoleColor:
    def __init__(self, *args):
        if len(args) == 0:
            raise TypeError()
        codes = [ConsoleColor._get_value(a) for a in args]
        self.codes = ';'.join(codes)
        self.value = f'\033[{self.codes}m'

    def __str__(self):
        return self.value

    @staticmethod 
    def _get_value(var):
        if isinstance(var, ConsoleColor):
            return str(var.codes)
        else:
            return str(var)


# Styles
NO_EFFECT = ConsoleColor(0)
BOLD      = ConsoleColor(1)
UNDERLINE = ConsoleColor(2)
NEGATIVE1 = ConsoleColor(3)
NEGATIVE2 = ConsoleColor(5)
# Foreground
FG_BLACK  = ConsoleColor(30)
FG_RED    = ConsoleColor(31)
FG_GREEN  = ConsoleColor(32)
FG_YELLOW = ConsoleColor(33)
FG_BLUE   = ConsoleColor(34)
FG_PURPLE = ConsoleColor(35)
FG_CYAN   = ConsoleColor(36)
FG_WHITE  = ConsoleColor(37)
# Background
BG_BLACK  = ConsoleColor(40)
BG_RED    = ConsoleColor(41)
BG_GREEN  = ConsoleColor(42)
BG_YELLOW = ConsoleColor(43)
BG_BLUE   = ConsoleColor(44)
BG_PURPLE = ConsoleColor(45)
BG_CYAN   = ConsoleColor(46)
BG_WHITE  = ConsoleColor(47)


def pretty_print(*args, **kwargs):
    """
        Prints pretty.
        
        Example:
            pretty_print(BG_RED, 'sample1')
          is the same as:
            print(BG_RED, 'sample1', NO_EFFECT, sep='')
    """
    # Assert there wont be two end params in kwargs
    if 'end' in kwargs:
        kwargs['end'] = f'{NO_EFFECT}{kwargs["end"]}'
    else:
        kwargs['end'] = f'{NO_EFFECT}\n'
    if not 'sep' in kwargs:
        kwargs['sep'] = ''
    # Print
    print(*args, **kwargs)
