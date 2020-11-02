#! python3
# password locker copy to clipboard but insecure

PASSWORDS = {'email': 'F7minlBDDuvMJuxESSKHFhTxFtjVB6',
            'blog': 'VmALvQyKAxiVH5G8v01if1MLZF3sdt',
            'luggage': '12345'}

import sys, pyperclip
if len(sys.argv) < 2:
    print('Usage: python pw.py [account] - copy account password')
    sys.exit()

account = sys.argv[1]
print("pulling password for {}".format(account))

if account in PASSWORDS:
    pyperclip.copy(PASSWORDS[account])
    print('Password for {} copied to clipboard'.format(account))
else:
    print("There is no account named " + account)
